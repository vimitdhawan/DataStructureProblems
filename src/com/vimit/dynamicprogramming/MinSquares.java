package com.vimit.dynamicprogramming;
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
        import java.lang.*;
        import java.io.*;
class MinSquares
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            MinSolution ob = new MinSolution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class MinSolution
{
    public int MinSquares(int n)
    {
        int[] minSquaresRequired = new int[n + 1];

        minSquaresRequired[0] = 0;

        minSquaresRequired[1] = 1;

        for (int i = 2; i <= n; ++i)

        {

            minSquaresRequired[i] = Integer.MAX_VALUE;

            for (int j = 1; i - (j * j) >= 0; ++j)

            {

                minSquaresRequired[i] = Math.min(minSquaresRequired[i], minSquaresRequired[i - (j * j)]);
            }

            minSquaresRequired[i] += 1;
        }

        int result = minSquaresRequired[n];

        return result;
    }

}
