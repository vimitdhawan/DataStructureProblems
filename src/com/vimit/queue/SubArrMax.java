package com.vimit.queue;

import java.io.*;
import java.util.*;

public class SubArrMax {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new TreeMap<>();

        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String detail = br.readLine();
            String[] detailArr = detail.split("\\s+");
            int k = Integer.parseInt(detailArr[1]);
            int n = Integer.parseInt(detailArr[0]);
            String data1 = br.readLine();
            String[] strs1 = data1.split("\\s+");
            int[] arr = new int[n];
            for (int t = 0; t < n; t++) {
                arr[t]=Integer.parseInt(strs1[t]);
            }
            Deque<Integer> queue = new LinkedList<>();
            int p;
            for(p=0; p<k; p++){
                while(!queue.isEmpty() && arr[p] >= arr[queue.peekLast()]){
                    queue.removeLast();
                }
                queue.addLast(p);
            }

            for(; p<n; p++){
                log.write(arr[queue.peek()] + " ");
                while(!queue.isEmpty() && queue.peek()<=p-k){
                    queue.removeFirst();
                }
                while(!queue.isEmpty() && arr[p] >= arr[queue.peekLast()]){
                    queue.removeLast();
                }
                queue.addLast(p);

            }

            log.write(arr[queue.peek()]+" ");
            log.newLine();

        }
        log.flush();


    }
}
