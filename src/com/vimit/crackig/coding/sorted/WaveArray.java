package com.vimit.crackig.coding.sorted;

import java.io.*;

/*
1
5
1 2 3 4 5
*/


public class WaveArray {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());// taking size of array
            int arr[] = new int[n]; // declaring array of size n
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(inputLine[i]); // input elements of array
            }

            WaveArraySolution obj = new WaveArraySolution();


            obj.convertToWave(arr, n);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");

            System.out.println(sb); // print array
        }
    }
}


// } Driver Code Ends
class WaveArraySolution {


    // arr: input array
    // n: size of the array
    //Function to sort the array into a wave-like array.
    public static void convertToWave(int arr[], int n){

        for(int i =0; i<n-1; i=i+2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

    }

}


// { Driver Code Starts.
// } Driver Code Ends