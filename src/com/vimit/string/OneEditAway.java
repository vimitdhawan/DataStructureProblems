package com.vimit.string;


import com.sun.swing.internal.plaf.synth.resources.synth_sv;

public class OneEditAway {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println( isOneAway("abcde", "abcd"));  // should return true
        isOneAway("abde", "abcde");  // should return true
        isOneAway("a", "a");  // should return true
        isOneAway("abcdef", "abqdef");  // should return true
        isOneAway("abcdef", "abccef");  // should return true
        isOneAway("abcdef", "abcde");  // should return true
        isOneAway("aaa", "abc");  // should return false
        isOneAway("abcde", "abc");  // should return false
        isOneAway("abc", "abcde");  // should return false
        isOneAway("abc", "bcc");  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        if(s2.length()>s1.length()){
            String temp ="";
            temp = s1;
            s1 = s2;
            s2 = temp;
        }
        if(s1.length()-s2.length()>1) return false;
        else if(s1.length()-s2.length()==1) return getOneEditFromAdd(s1,s2);
        else return getOneEditFromReplace(s1, s2);
    }

    private static Boolean getOneEditFromReplace(String s1, String s2) {
        int i = 0;
        boolean isFirst = false;
        boolean isSecond = false;
        while(i<s1.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(isFirst){
                    isSecond = true;
                    break;
                } else {
                    isFirst = true;
                }
            }
            i++;
        }
        return !isSecond;
    }

    private static Boolean getOneEditFromAdd(String s1, String s2) {
        int i = 0;
        int j = 0;
        boolean isFirst = false;
        while(j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                if(isFirst){
                    break;
                }
                i++;
                isFirst = true;
            } else {
                i++;
                j++;
            }
        }
        if(j==s2.length()){
            return true;
        }else {
            return false;
        }
    }
}
