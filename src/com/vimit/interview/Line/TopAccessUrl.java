package com.vimit.interview.Line;

import java.util.*;
import java.util.stream.Collectors;

public class TopAccessUrl {
    public static void main(String[] args) {
        TopAccessUrl  topAccessUrl = new TopAccessUrl();
        String[] arr = new String[]{"10.20.31.12 200 http://example.com/index", "10.20.31.12 200 http://example.com/bndex", "10.20.30.12 200 http://example.com/welcome", "10.20.31.11 200 http://example.com/index", "192.168.10.12 200 http://example.com/index", "192.168.15.12 404 http://example.com/nonono", "192.168.17.12 404 http://example.com/nonono"};
        System.out.println(Arrays.toString(topAccessUrl.solution(2, arr)));
    }
    public String[] solution(int n, String[] logs) {
        Map<String, Url> ipDict = new HashMap<>();
        for(int i =0; i<logs.length; i++){
            String[] logsDetail = logs[i].split("\\s+");
            if(logsDetail.length == 3 && logsDetail[1].equals("200")){
                if(ipDict.containsKey(logsDetail[2])){
                    ipDict.get(logsDetail[2]).increment();
                } else{
                    ipDict.put(logsDetail[2], new Url(logsDetail[2]));
                }
            }
        }
        List<Url> urls  = ipDict.values().stream().collect(Collectors.toList());
        List<String> validUrls = new ArrayList<>();
        Collections.sort(urls);
        for(int j=0; j<urls.size(); j++){
            if(n>j){
                validUrls.add(urls.get(j).value);
            } else{
                break;
            }
        }
        return validUrls.toArray(new String[validUrls.size()]);

    }
}

class Url implements  Comparable<Url>{
    Integer count;
    String value;
    Url(String value){
        this.count = 1;
        this.value = value;
    }
    public void increment(){
        this.count = this.count+1;
    }

    @Override
    public int compareTo(Url o) {
        if(o.count.compareTo(this.count)==0){
            return this.value.compareTo(o.value);
        }
        return o.count.compareTo(this.count);
    }
}
