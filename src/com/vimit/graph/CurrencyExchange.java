package com.vimit.graph;

import java.util.*;

public class CurrencyExchange {
    public static void main(String[] args) {
        CurrencyExchange currencyExchange = new CurrencyExchange();
        String[][] rates = {{"USD", "EUR"},{"EUR", "JPY"},{"USD", "JPY"}};
        System.out.println(currencyExchange.exchangeCurrencyDFS(rates, "USD", "GER"));
        System.out.println(currencyExchange.exchangeCurrencyBFS(rates, "USD", "JPY"));
    }

    boolean exchangeCurrencyDFS(String[][] rates, String from, String to){
        Map<String, List<String>> graph = createCurrencyGraph(rates);
        Set<String> visited = new HashSet<>();
        return traverseCurrency(graph, visited, from, to);
    }

    private boolean traverseCurrency(Map<String, List<String>> graph, Set<String> visited, String from, String to) {
        if(from.equals(to)) return true;
        if(graph.containsKey(from) && !visited.contains(from)){
            visited.add(from);
            List<String> neighbours = graph.get(from);
            for(String neighbour: neighbours){
                boolean isFound =  traverseCurrency(graph, visited, neighbour, to);
                if(isFound) return true;
            }

        }
        return false;
    }

    public Map<String, List<String>> createCurrencyGraph(String[][] rates){
        Map<String, List<String>> graph = new HashMap<>();
        for(int i =0; i<rates.length; i++){
            List<String> neighbours = graph.getOrDefault(rates[i][0], new ArrayList<>());
            neighbours.add(rates[i][1]);
            graph.put(rates[i][0], neighbours);
        }
        return graph;
    }

    boolean exchangeCurrencyBFS(String[][] rates, String from, String to){
        Map<String, List<String>> graph = createCurrencyGraph(rates);
        if(!graph.containsKey(from)) return false;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(from);
        while(!queue.isEmpty()){
            String fromCurrency = queue.poll();
            visited.add(fromCurrency);
            List<String> neighbours = graph.getOrDefault(fromCurrency, new ArrayList<>());
            boolean isFound =false;
            for(String neighbour: neighbours){
                if(!visited.contains(neighbour)){
                    if(neighbour.equals(to)){
                        isFound = true;
                        break;
                    }
                    else queue.offer(neighbour);
                }
            }
            if(isFound) return true;
        }

        return false;
    }


}
