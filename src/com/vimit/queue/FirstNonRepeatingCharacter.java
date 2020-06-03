package com.vimit.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String data1 = br.readLine();
            String[] strs1 = data1.split("\\s+");
            Queue<Character> queue = new LinkedList<>();
            int[] tracking = new int[256];
            for (int k = 0; k < length; k++) {
                Character value = strs1[k].charAt(0);
                queue.add(value);
                tracking[value] = tracking[value]+1;
                while(!queue.isEmpty()){
                    if(tracking[queue.peek()]>1){
                        queue.remove();
                    }else{
                        System.out.print(queue.peek()+" ");

                        break;
                    }
                }
                if(queue.isEmpty()){
                    System.out.print(-1+" ");
                }
            }
        }
    }

}
