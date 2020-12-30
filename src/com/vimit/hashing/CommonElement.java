package com.vimit.hashing;


import java.util.*;

public class CommonElement
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];

            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }

            ArrayList<Integer> res = commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }
            }
            System.out.println();
        }
    }

    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        int i=0,j=0,k=0;
        boolean isFirst = false;
        ArrayList<Integer> output = new ArrayList<>();
        while(i<n1 && j<n2 && k<n3){
            if(A[i]==B[j]){
                isFirst = true;
            } else if(A[i]<B[j]){
                i++;
            } else{
                j++;
            }
            while(isFirst && k<n3){
                if(A[i]==C[k]){
                    final int value = C[k];
                    if(!output.stream().anyMatch(t -> t == value)){
                        output.add(A[i]);
                    }
                    isFirst = false;
                    i++;
                }else if(C[k]<A[i]){
                    k++;
                } else{
                    isFirst = false;
                    i++;
                }

            }
        }

        return output;
    }
}


