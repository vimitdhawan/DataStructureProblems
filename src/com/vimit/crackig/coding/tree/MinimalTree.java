package com.vimit.crackig.coding.tree;

//Initial Template for Java
/*
1
7
1 2 3 4 5 6 7
*/

import java.lang.*;
        import java.io.*;
public class MinimalTree
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            SolutionMinimalTree obj = new SolutionMinimalTree();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class SolutionMinimalTree
{
    static int insertion =0;
    public int[] sortedArrayToBST(int[] nums)
    {
        insertion =0;
        int[] output = new int[nums.length];
        traverseArray(nums, output, 0, nums.length-1);
        return output;
    }

    public void traverseArray(int[] nums, int[] output, int left, int right){
        if(left>right) return;
        int middle = (left + right)/2;
        output[insertion] = nums[middle];
        insertion++;
        traverseArray(nums, output, left, middle-1);
        traverseArray(nums, output, middle+1, right);
    }


}