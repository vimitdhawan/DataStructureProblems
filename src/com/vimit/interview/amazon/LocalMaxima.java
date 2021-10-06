package com.vimit.interview.amazon;

import java.util.*;
public class LocalMaxima {
    public static void main(String[] args) {
    List<Integer> list = Arrays.asList(5, 2,5 ,4,6,8);
        System.out.print(segment(3,list));
        int[] arrnew = new int[]{5, 2,5 ,4,6,8};
        System.out.print(Arrays.toString(maxSlidingWindow(arrnew, 3)));
    }


    public static int segment(int x, List<Integer> space) {
        List<Integer> localMinima = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i<space.size(); i++){
            while(!queue.isEmpty() && queue.peek() <= i-x){
                queue.poll();
            }
            while(!queue.isEmpty() && space.get(queue.peekLast())<space.get(i)){
                queue.pollLast();
            }
            queue.offer(i);
            if(i>=x-1){
                localMinima.add(space.get(queue.peek()));
            }
        }
        return Collections.max(localMinima);

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null && k<=0){
            return new int[0];
        }
        int[] slidingMax = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i =0; i<nums.length; i++){
            while(!queue.isEmpty() && queue.peek() <= i-k){
                queue.poll();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(i>=k-1){
                slidingMax[i+1-k] = nums[queue.peek()];
            }
        }
        return slidingMax;
    }


}
