package com.vimit.crackig.coding.hard;

/*
1
12
i like sam sung samsung mobile ice cream icecream man go mango
ilike
*/

import java.io.*;
        import java.util.*;
import java.util.stream.Collectors;

public class WordBreak
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n;
            n = sc.nextInt();
            ArrayList<String> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
            {
                String p = sc.next();
                arr.add(p);
            }
            String line = sc.next();
            SolWordBreak obj = new SolWordBreak();
            System.out.println(obj.wordBreak(line,arr));

        }
    }
}// } Driver Code Ends


//User function Template for Java

class SolWordBreak
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        Set<String> hashSet =  B.stream().collect(Collectors.toSet());
        if(recursiveStringMatch(A, hashSet)) return 1;
        else return 0;
    }

    public static boolean recursiveStringMatch(String value, Set<String> hashSet){
        if(hashSet.contains(value)){
            return true;
        }
        for(int t=0; t<value.length(); t++){
            String left = value.substring(0, t);
            String right= value.substring(t);
            if(hashSet.contains(left)){
                return recursiveStringMatch(right, hashSet);
            }
        }
        return false;
    }

}