package com.vimit.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeMaxMin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String value  = br.readLine();
            String[] strarr = value.split(" ");
            int arr[] = new int[length];
            for(int t=0; t<strarr.length; t++){
                arr[t] = Integer.parseInt(strarr[t]);
            }
            rearrange(arr, length);
            for (int k = 0; k < length; k++)
                System.out.print(arr[k] + " ");
            System.out.println();
        }
    }

        public static void rearrange(int arr[], int n)
        {
            // initialize index of first minimum and first
            // maximum element
            int max_idx = n - 1, min_idx = 0;

            // store maximum element of array
            int max_elem = arr[n - 1] + 1;

            // traverse array elements
            for (int i = 0; i < n; i++) {
                // at even index : we have to put
                // maximum element
                if (i % 2 == 0) {
                    arr[i] += (arr[max_idx] % max_elem) * max_elem;
                    max_idx--;
                }

                // at odd index : we have to put minimum element
                else {
                    arr[i] += (arr[min_idx] % max_elem) * max_elem;
                    min_idx++;
                }
            }

            // array elements back to it's original form
            for (int i = 0; i < n; i++)
                arr[i] = arr[i] / max_elem;
        }


    }
