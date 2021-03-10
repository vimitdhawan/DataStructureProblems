package com.vimit.dynamicprogramming;



//Initial Template for Java


import java.util.*;
        import java.lang.*;
        import java.io.*;

        public class StackBox
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
    static int maxHeight =  0;
    static int box_length = Integer.MAX_VALUE;
    static int box_width = Integer.MAX_VALUE;
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
                return b2.height- b1.height;
            }
            return b2.area - b1.area;
        });
        int total = n*3;
        int[] memo = new int[n * 3];
        return getMaxHeight(list, memo);
        // your code here
    }

    static int getMaxHeight(ArrayList<Box> list , int[] memo){
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (list.get(i).length < list.get(j).length &&
                        list.get(i).width < list.get(j).width)
                {
                    memo[i] = Math.max(memo[i], memo[j]);
                }
            }

            memo[i] += list.get(i).height;
        }

        return Arrays.stream(memo).max().getAsInt();
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
            this.area = length * width ;
        }
    }
}

