package com.vimit.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SortingArrFrequency {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String data = br.readLine();
            String[] strs = data.split("\\s+");
            int arr[] = new int[strs.length];
            class Pair{
                Integer index;
                Integer count;
                Pair(Integer index, Integer count) {
                    this.index = index;
                    this.count = count;
                }

                public void increment(){
                    this.count = this.count+1;
                }
            }
            Map<Integer, Pair> map = new HashMap<>();
            for (int j = 0; j < strs.length; j++) {
                arr[j] = Integer.parseInt(strs[j]);
                if(map.containsKey(arr[j])){
                     map.get(arr[j]).increment();
                } else{
                    map.put(arr[j], new Pair(j,1));
                }

            }

           List<Pair> list =  map.values().stream().sorted(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.count.compareTo(o2.count)==0){
                        return o1.index.compareTo(o2.index);
                    } else {
                       return  o1.count.compareTo(o2.count)*-1;
                    }
                }
            }).collect(Collectors.toList());

            final Integer[] output = new Integer[length];
            int index=0;
            for(int m=0; m<list.size(); m++){
                Pair pair = list.get(m);
                int t = pair.count;
                while(t>0){
                    output[index] = arr[pair.index];
                    t--;
                    index++;
                }
            }

            System.out.print(Arrays.toString(output));
        }

    }

}
