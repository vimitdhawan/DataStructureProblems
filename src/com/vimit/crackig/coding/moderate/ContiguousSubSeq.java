package com.vimit.crackig.coding.moderate;

import java.io.*;

/*
1
5
1 2 3 -2 5
*/


public class ContiguousSubSeq  {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            ContiguousSubSeqSolution obj = new ContiguousSubSeqSolution();

            //calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr, n));
        }
    }
}

// } Driver Code Ends


class ContiguousSubSeqSolution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){

        int maxSum = arr[0];
        int currentSum = arr[0];
        for(int i=1; i<n; i++){
            currentSum = currentSum+arr[i];
            if(arr[i] > currentSum){
                currentSum = arr[i];
            }
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;

    }

}


