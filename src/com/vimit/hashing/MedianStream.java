package com.vimit.hashing;

import java.util.*;
import java.lang.*;


class MedianStream
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int n;
        while(t-- > 0){
            n = sc.nextInt();

            FindMedian Ans = new FindMedian();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                Ans.insertHeap(x);
                System.out.println((int)Math.floor(Ans.getMedian()));
            }
        }


    }
}

// } Driver Code Ends


class FindMedian
{
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Function to insert heap
    public static void insertHeap(int num)
    {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        } else if(maxHeap.peek()<num){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }
        balanceHeaps();
        // add your code here
    }

    // Function to balance Heaps
    public static void balanceHeaps()
    {
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }else if((maxHeap.size()-minHeap.size())>1){
            minHeap.add(maxHeap.poll());
        }

    }
    // add your code here


    // function to getMedian
    public static double getMedian()
    {

        double divider =2;
        if(minHeap.size() == maxHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/divider;
        }else{
            return maxHeap.peek();
        }

    }

}