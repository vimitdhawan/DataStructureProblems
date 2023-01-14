package com.vimit.assignments.tree;
import java.util.*;

public class IntegerSetTest {
    public static void main(String[] args) {
        IntegerSet iss = new IntegerSet(new int[]{});
        System.out.println(iss.getMin());
        IntegerSet is = new IntegerSet(new int[]{1,2,3});
        IntegerSet other = new IntegerSet(new int[]{2,3,5,6});
        System.out.println(is);
        System.out.println(is.difference(other));
        System.out.println(is.union(other));
        System.out.println(is.symmetricDifference(other));
        System.out.println(is.intersection(other));
        System.out.println(is.getMin());
        System.out.println(other.getMax());
        is.add(7);
        System.out.println(is);
        is.remove(2);
        System.out.println(is);

    }


}
