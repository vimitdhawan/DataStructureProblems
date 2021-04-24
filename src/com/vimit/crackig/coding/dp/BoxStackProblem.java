package com.vimit.crackig.coding.dp;
//Initial Template for Java


import java.util.*;
        import java.lang.*;
        import java.io.*;

public class BoxStackProblem
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        //sc.next();
        while(t-- > 0)
        {
            int n = sc.nextInt();

            int A[]  =new int[1000];
            int B[] = new int[1000];
            int C[] = new int[1000];

            for(int i = 0; i < n; i++)
            {
                int a =sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                A[i] = a;
                B[i] = b;
                C[i] = c;
            }

            Geeks ob = new Geeks();
            System.out.println(ob.maxHeight(A,B,C,n));
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Geeks
{
    public static int maxHeight(int height[], int width[], int length[], int n)
    {
        ArrayList<Box> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Box(height[i], Math.max(width[i],length[i]), Math.min(width[i],length[i])));
            list.add(new Box(width[i], Math.max(height[i],length[i]), Math.min(height[i],length[i])));
            list.add(new Box(length[i], Math.max(width[i],height[i]),Math.min(width[i],height[i]) ));
        }
        Collections.sort(list, (Box b1, Box b2) -> {
            if(b2.area - b1.area == 0){
                return b2.height - b1.height;
            }
            return b2.area - b1.area;
        });
        int maxHeight = 0;
        int[] memo = new int[n * 3];
        for(int j=0; j<list.size(); j++){
            int currentHeight = getMaxHeight(list, memo, j);
            maxHeight = Math.max(currentHeight, maxHeight);
        }

        return maxHeight ;
        // your code here
    }

    static int getMaxHeight(ArrayList<Box> list , int[] memo, int i){
        if(memo[i]>0) return memo[i];
        Box bottom = list.get(i);
        int maxHeight = 0;
        for (int j = i+1; j < list.size(); j++){
            if (list.get(j).canBeAbove(bottom)){
                int height = getMaxHeight(list, memo, j);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight = maxHeight + bottom.height;
        memo[i] = maxHeight;

        return maxHeight;
    }

    static class Box{
        int length;
        int width;
        int height;
        int area;
        Box(int height, int width, int length){
            this.length = length;
            this.width = width;
            this.height = height;
            this.area = length*width;
        }

        boolean canBeAbove(Box box){
            return this.length < box.length &&
                    this.width < box.width;
        }
    }
}

