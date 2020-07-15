package com.vimit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MeetingProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String data1 = br.readLine();
            String data2 = br.readLine();
            String[] strs1 = data1.split("\\s+");
            String[] strs2 = data2.split("\\s+");
            List<Meeting> list = new ArrayList<>();
            for (int k = 0; k < strs2.length; k++) {
                list.add(new Meeting(Integer.parseInt(strs1[k]), Integer.parseInt(strs2[k]), k+1));
            }
            Collections.sort(list, new Comparator<Meeting>() {
                @Override
                public int compare(Meeting o1, Meeting o2) {
                    return Integer.compare(o1.end , o2.end);
                }
            });
            List<Integer> result = new ArrayList<>();
            int last = -1;
            for(int t =0; t<list.size(); t++){
                Meeting current = list.get(t);
                if(current.start>=last){
                    result.add(current.index);
                    last = current.end;
                }
            }

            for(int p=0; p<result.size(); p++) {
                System.out.print(result.get(p) + " ");
            }
            System.out.println();

        }
    }
   static class Meeting {
        int start;
        int end;
        int index;
        Meeting(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;

        }
    }
}
