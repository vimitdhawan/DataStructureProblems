package com.vimit.crackig.coding.dp;

//Initial Template for Java

import java.io.*;
import java.util.*;

// input
// 1 <- test case
// 2 <- parentheses count

public class Generateparentheses{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }

            t--;

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    public List<String> AllParenthesis(int n)
    {
        List<String> list = new ArrayList<>();
        getParanthesis("",n, n, list);
        return list;
    }

    public void getParanthesis(String output, int open, int close, List<String> result){
        if(open == 0 && close == 0) result.add(output);
        else if(open == 0 && close !=0) getParanthesis(output + ")", open, close-1, result);
        else if(open>=close) getParanthesis(output+"(", open-1, close, result);
        else{
            getParanthesis(output + "(", open-1, close, result);
            getParanthesis(output + ")", open, close-1, result);

        }
    }
}
