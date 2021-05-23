package com.vimit.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        System.out.println(sr.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if(x<=1) return x;
        int start = 0, end = 46339;
        int ans = 0;
        while(start<=end){
            int mid = (start +end)/2;
            double res = mid*mid;
            if(mid>0 && res<mid){
                end = mid/2;
            } else{
                if(res == x){
                    return mid;
                }
                if(res < x){
                    start = mid +1;
                    ans = mid;
                }else{
                    end = mid-1;
                }
            }


        }

        return ans;
    }
}




