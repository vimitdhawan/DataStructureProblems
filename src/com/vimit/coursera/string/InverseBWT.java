package com.vimit.coursera.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InverseBWT {
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

    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        String [] bwtArr = new String[bwt.length()];
        String[] frontArr = new String[bwt.length()];
        int index=0;
        for(int i=0; i<bwt.length(); i++){
            Character temp = bwt.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else{
                map.put(temp, 1);
            }
            bwtArr[i] = temp + map.get(temp).toString();
            frontArr[i] = temp + map.get(temp).toString();
            if(bwtArr[i].charAt(0) == '$') index = i;
        }

        Arrays.sort(frontArr);



        for(int t=0; t<bwtArr.length; t++){
            result.append(frontArr[index].charAt(0));
            String c = frontArr[index];
            for(int i =0; i<bwtArr.length; i++){
                if(c.equals(bwtArr[i])){
                    index = i;
                    break;
                }
            }
        }
        // write your code here

        return result.toString();
    }


    static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}

