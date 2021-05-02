package com.vimit.dynamicprogramming;
import java.util.*;
import java.lang.*;

public class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases


        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static ArrayList <String> possibleWords(int a[], int N)
    {
        Map<Integer, String> PhoneMap =  new HashMap<>();
        PhoneMap.put(2, "abc");
        PhoneMap.put(3, "def");
        PhoneMap.put(4, "ghi");
        PhoneMap.put(5, "jkl");
        PhoneMap.put(6, "mno");
        PhoneMap.put(7, "pqrs");
        PhoneMap.put(8, "tuv");
        PhoneMap.put(9, "wxyz");
        ArrayList<String> result = new ArrayList<>();
        gePossibleWords(PhoneMap, a, "", 0, N, result);
        ArrayList<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(result));

        return result;

    }

    static void gePossibleWords( Map<Integer, String> PhoneMap, int a[], String prefix, int current, int N, ArrayList<String> result){
        if(current == N){
            result.add(prefix);
        }else{
            String value = PhoneMap.get(a[current]);
            for(char c : value.toCharArray()){
                gePossibleWords(PhoneMap, a, prefix+c, current+1, N, result);

            }

        }


    }


}


