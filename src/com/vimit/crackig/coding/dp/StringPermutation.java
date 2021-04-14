package com.vimit.crackig.coding.dp;

//Initial Template for Java
// 1 <- test cases
// 3 4 <- edges. nodes
// 3 0 <- edge
// 1 0
// 2 0
// 1<- test Cases
// ABSG <- Input
import java.io.*;
        import java.util.*;

public class StringPermutation {
    public static void main (String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0)
        {
            String s = scn.nextLine();
            SolutionPerm obj = new SolutionPerm();
            ArrayList<String> ans = new ArrayList<String>();
            ans = obj.permute(s);
            Collections.sort(ans);
            for(String x: ans)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class SolutionPerm{
    public static ArrayList<String> permute(String s){
        ArrayList<String> result = new ArrayList<String>();
        recursivePermutation("", s, result);
        Collections.sort(result);
        return result;
    }

    public static void recursivePermutation(String prefix, String remainder,  ArrayList<String> result){
        if(remainder.length() == 0){
            result.add(prefix);
        }else{
            for(int i =0; i<remainder.length(); i++){
                String before = remainder.substring(0,i);
                String after = remainder.substring(i+1);
                char c = remainder.charAt(i);
                recursivePermutation(prefix + c, before+after, result);
            }
        }
    }
}
