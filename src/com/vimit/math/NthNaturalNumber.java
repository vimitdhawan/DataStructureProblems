package com.vimit.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class NthNaturalNumber {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<Integer>(1);
        a.add(2);
        result.add(a);
        Collections.reverse(result);
        Collections.sort(result, Comparator.comparingInt(t -> t.get(0)));
       System.out.println(findNth(9));
    }

    static long findNth(long N){

        return Long.valueOf(Long.toString(N, 9));
    }
}


