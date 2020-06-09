package com.vimit.Array;

// Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
//Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

// modify merge sort

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InversionArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String data1 = br.readLine();
            String[] strs1 = data1.split("\\s+");
            int[] arr = new int[strs1.length];
            for (int k = 0; k < length; k++) {
                arr[k] = Integer.parseInt(strs1[k]);
            }

            long count = getInversionCount(arr, 0, arr.length-1);
            System.out.println(count);
        }

    }

    private static long getInversionCount(int[] arr, int start, int end) {
        long inv_count=0;
        if(end>start) {
            int middle = (start+end)/2;
            inv_count += getInversionCount(arr, start, middle);
            inv_count += getInversionCount(arr, middle+1, end);
            inv_count += mergeSort(arr, start, middle, end);
        }
        return inv_count;
    }

    private static long mergeSort(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end-start+1];
        int i = start;
        int j = middle+1;
        int index = 0;
        long counter =0;
        while(i<=middle && j<=end){
            if(arr[i]<=arr[j]){
                temp[index] = arr[i];
                i++;
            } else{
                temp[index] = arr[j];
                counter+=middle+1-i;
                j++;

            }
            index++;

        }

        while(i<=middle){
            temp[index] = arr[i];
            i++;
            index++;
        }

        while(j<=end){
            temp[index] = arr[j];
            j++;
            index++;

        }


        for(int k =0; k<temp.length; k++){
            arr[start+k] = temp[k];
        }
        return  counter;
    }

}
