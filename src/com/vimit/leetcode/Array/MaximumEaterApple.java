package com.vimit.leetcode.Array;

import java.util.*;
public class MaximumEaterApple {
    public static void main(String[] args) {
        MaximumEaterApple max = new MaximumEaterApple();
        int[] apple = new int[]{1,2,3,5,2};
        int[] days = new int[]{3,2,1,4,2};
        max.eatenApples(apple, days);

    }

    public int eatenApples(int[] apples, int[] days) {
        int res = 0;
        int n = apples.length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int i=0; i<n || !queue.isEmpty(); ++i) {
            if(i<n){
                queue.offer(new int[]{ i, i + days[i] });
            }
            while(!queue.isEmpty() && queue.peek()[1] <= i) {
                queue.poll();
            }

            if(!queue.isEmpty()) {
                ++res;
                if(--apples[queue.peek()[0]] == 0) // remove if no apples left on this tray
                    queue.poll();
            }
        }

        return res;
    }
}
