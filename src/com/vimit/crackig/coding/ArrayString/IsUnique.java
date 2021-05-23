package com.vimit.crackig.coding.ArrayString;

import java.util.Scanner;

public class IsUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(checkUnique(input)) System.out.println("Unique");
        else System.out.println("Not Unique");
    }

    public static boolean checkUnique(String input){
        if(input.length()>256) return false;
        boolean[] memo = new boolean[256];
        for(int i=0; i<input.length(); i++){
            if(memo[input.charAt(i)])
                return false;
            else memo[input.charAt(i)] = true;
        }
        return true;
    }
}
