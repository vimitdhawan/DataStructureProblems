package com.vimit.leetcode;

import java.util.Arrays;

public class RotateInplace {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        rotate(arr, 5);
        System.out.println(Arrays.toString(arr));

    }

    public static void rotate(int[] nums, int d) {
        if(d>0 && nums.length!=d) {
            /* To handle if d >= n */
            int n = nums.length;
            d = d % n;
            int i, j, k, temp;
            int g_c_d = gcd(n, d);
            for (i = 0; i < g_c_d; i++) {
                /* move i-th values of blocks */
                temp = nums[n - (i + g_c_d)];
                j = n - (i + g_c_d);
                while (true) {
                    k = j - d;
                    if (k < 0)
                        k = k + n;
                    if (k == n - (i + g_c_d))
                        break;
                    nums[j] = nums[k];
                    j = k;
                }
                nums[j] = temp;
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
