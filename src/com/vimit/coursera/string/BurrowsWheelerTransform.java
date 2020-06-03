package com.vimit.coursera.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BurrowsWheelerTransform {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    String BWT(String text) {
        StringBuilder result = new StringBuilder();
        int len = text.length()-1;
        List<String> list = new ArrayList<>();
        for(int i=text.length()-1; i>=0; i-- ){
            text = text.charAt(len)+text.substring(0,len);
            list.add(text);
        }
        Collections.sort(list);
        List<Character> charList = list.stream().map(a -> a.charAt(len)).collect(Collectors.toList());
        for(int k=0; k<text.length(); k++){
            result.append(charList.get(k));
        }



        // write your code here

        return result.toString();
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}
