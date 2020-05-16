package com.vimit.string;

public class IsUnique {
    public static void main(String[] args) {
        String input = "abcd*()@#$";
        boolean result = getUnique(input);
        System.out.println(result);
    }

    private static boolean getUnique(String input) {
        int len = input.length();
        if(len>128) return false;

        boolean[] arr = new boolean[128];

        for(int i=0; i<len; i++){
            int index = input.charAt(i);
            if(arr[index]) {
                return false;
            }
            arr[index] = true;
        }
        return true;
    }
}
