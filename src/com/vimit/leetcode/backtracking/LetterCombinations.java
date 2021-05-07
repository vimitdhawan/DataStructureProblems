package com.vimit.leetcode.backtracking;
import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        lc.letterCombinations("23");
    }
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> numberCombinations = new HashMap<>();
        List<String> combinations = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wzyz");
        for(int i=0; i<8; i++){
            numberCombinations.put(i+2, combinations.get(i));
        }
        List<String> result = new ArrayList<String>();
        createCombinations(digits, 0, result, "", numberCombinations);
        return result;
    }

    public void createCombinations(String digits, int index, List<String> result, String prefix, Map<Integer, String> numberCombinations){
        if(index == digits.length()){
            result.add(prefix);
            return;
        }
        int combIndex = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String current = numberCombinations.get(combIndex);
        for(int i =0; i<current.length(); i++){
            createCombinations(digits, index+1, result, prefix+current.charAt(i),numberCombinations);
        }
    }
}
