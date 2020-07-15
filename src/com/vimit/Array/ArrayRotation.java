package com.vimit.Array;

public class ArrayRotation {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println( isRotation(array1, array2a)); // should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        // isRotation(array1, array2b) should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        // isRotation(array1, array2c) should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        // isRotation(array1, array2d) should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        // isRotation(array1, array2e) should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        // isRotation(array1, array2f) should return true.
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] array1, int[] array2) {
        boolean isRotation = true;
        if(array1.length!=array2.length) return false;
        int index1 = 0;
        int index2=0;
        boolean isFound = true;
        while(isRotation && index1<array1.length) {
            if(isFound && array1[index1]==array2[index2]){
                isFound = false;
                index2++;
            }else if(array1[index1]==array2[index2]){
                index2++;
            } else if(!isFound){
                isRotation = false;
            }
            index1++;
        }

        if(!isFound && isRotation){
            index1=0;
            while(isRotation && index2<array2.length){
                if(array1[index1]!=array2[index2]){
                    isRotation = false;
                }
                index1++;
                index2++;
            }
        }
        return isRotation;
    }
}
