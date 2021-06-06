package com.vimit.interview.Beam;

public class PermutationString {

    public static void main(String[] args) {
        PermutationString ps = new PermutationString();
        System.out.println(ps.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        for(int j =0; j<s1.length(); j++){
            int index = s1.charAt(j)-'a';
            arr[index] =  arr[index] +1;
        }
        for(int i =0; i<s2.length(); i++){
            if(s1.length()<=s2.length()-i && recursiveCharacterMatch(s2, i, arr, s1.length()))
                return true;
        }
        return false;
    }
    public boolean recursiveCharacterMatch(String input, int index, int[] arr, int count){
        if(count == 0) return true;
        if(index == input.length()) return false;
        int currentIndex = input.charAt(index) -'a';
        boolean isMatch = false;
        if(arr[currentIndex]>0){
            arr[currentIndex] = arr[currentIndex]-1;
            isMatch = recursiveCharacterMatch(input, index+1, arr, count-1);
            arr[currentIndex] = arr[currentIndex]+1;
        }
        return isMatch;
    }
}
