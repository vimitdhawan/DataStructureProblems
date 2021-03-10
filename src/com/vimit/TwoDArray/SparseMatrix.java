package com.vimit.TwoDArray;

import java.util.Scanner;

public class SparseMatrix
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[n][m];
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++ )
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.findK(arr, n, m, k));
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{

    public int findK(int a[][], int n, int m, int k)
    {
        int i=0;
        int j=0;
        m =m-1;
        n =n-1;
        int counter =0;
        int traverse =0;
        int[] arr = new int[((n+1)*(m+1))];
        while(i<=n && j<=m){
            for(traverse=j; traverse<=m; traverse++){
                arr[counter] = a[i][traverse];
                counter++;
            }
            i++;

            for(traverse=i; traverse<=n; traverse++){
                arr[counter] = a[traverse][m];
                counter++;
            }
            m--;

            if(i<=n){
                for(traverse=m; traverse>=j; traverse--){
                    arr[counter] = a[n][traverse];
                    counter++;
                }
                n--;
            }


            if(j<=m){
                for(traverse=n; traverse>=i; traverse--){
                    arr[counter] = a[traverse][j];
                    counter++;
                }
                j++;
            }

        }

        return arr[k];
    }

}