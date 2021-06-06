package com.vimit.interview.Line;
import java.util.*;
public class BracketSolution {
    public static void main(String[] args) {
        BracketSolution bs = new BracketSolution();
       String[] arr =  bs.solution(3);

        System.out.print(Arrays.toString(arr));
    }

    public String[] solution(int n) {
        List<String> result = new ArrayList<>();
        recursiveBracket(n, n, "", result);
         String[] arr = result.toArray(new String[result.size()]);
        Arrays.sort(arr);
        return   arr;
    }

    public void recursiveBracket(int open, int close, String prefix, List<String> result){
        if(open ==0 && close ==0) result.add(prefix);
        else if(open == close){
            recursiveBracket(open-1, close, prefix+"(", result);
        }else{
            if(open>0){
                recursiveBracket(open-1, close, prefix+"(", result);
            }
            if(close>0){

                recursiveBracket(open, close-1, prefix+")", result);
            }

        }

    }
}
