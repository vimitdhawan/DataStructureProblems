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
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    // Function to insert heap
    public static void insertHeap(int x)
    {
        if(max.isEmpty()){
            max.add(x);
        } else if(x > max.peek()){
            min.add(x);
            balanceHeaps();
        } else{
            max.add(x);
            balanceHeaps();
        }
        // add your code here
    }

    // Function to balance Heaps
    public static void balanceHeaps()
    {
        int sizeDiff = min.size()>max.size() ? min.size()-max.size():max.size()-min.size();
        if(sizeDiff>1){
            if(min.size()>max.size()){
                max.add(min.poll());
            }else{
                min.add(max.poll());
            }
        }

    }
    // add your code here


    // function to getMedian
    public static double getMedian()
    {

        if(min.size() == max.size()){
            return (min.peek() + max.peek())/2;
        } else if(min.size()>max.size()){
            return Double.valueOf(min.peek());
        } else{
            return Double.valueOf(max.peek());
        }

    }

}