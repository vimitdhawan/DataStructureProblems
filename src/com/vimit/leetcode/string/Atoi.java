package com.vimit.leetcode.string;

public class Atoi {
    public static void main(String[] args) {
        Atoi at = new Atoi();
        System.out.println(at.myAtoi("42"));
    }
    public int myAtoi(String s) {
        String trimSpace = removeSpace(s);
        int sign = trimSpace.charAt(0) == 45 ? -1 : 1;
        int startIndex = sign == 1 ? 0 : 1;
        long res = 0;
        while(startIndex<trimSpace.length() && res<Integer.MAX_VALUE){
            if(trimSpace.charAt(startIndex)>=48 && trimSpace.charAt(startIndex)<=57){
                res = res * 10 +  Integer.parseInt(String.valueOf(trimSpace.charAt(startIndex)));
            }else{
                break;
            }
            startIndex++;
        }

        if(res > Integer.MAX_VALUE){
            if(sign == 1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }

        return (int)res * sign;

    }

    private String removeSpace(String s){
        int i = 0;
        while(i<s.length() && (s.charAt(i) == 32 || s.charAt(i) == 48)){
            i++;
        }
        return s.substring(i, s.length());
    }
}
