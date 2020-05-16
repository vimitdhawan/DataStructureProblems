package com.vimit.string;

public class OnePermAnother {
    public static void main(String[] args) {
        String input1="abb";
        String input2="cbb";
        boolean result = getPermAnother(input1, input2);
        System.out.println(result);
    }

    private static boolean getPermAnother(String input1, String input2) {
        if(input1.length()!=input2.length()) return false;
        int[] arr = new int[128];

        for(int i =0; i<input1.length(); i++){
            int index = input1.charAt(i);
            arr[index] = arr[index] + 1;
        }

        for(int j=0; j<input2.length(); j++){
            int index = input2.charAt(j);
            arr[index] = arr[index]-1;
            if(arr[index]<0){
                return false;
            }
        }
        return true;

    }
}
