package com.vimit.interview.foodpanda;

// remove adjacent duplictae character
public class AdjacentDuplicateCharacter {
    public static void main(String[] args) {
        AdjacentDuplicateCharacter m2 = new AdjacentDuplicateCharacter();
    }

    public int solution(String S, int[] C) {
        int cost = 0;
        int currentIndex = 0;
        int nextIndex = 1;
        while(nextIndex<S.length()){
            if(S.charAt(currentIndex) == S.charAt(nextIndex)){
                 if(C[currentIndex]<C[nextIndex]){
                     cost = C[currentIndex];
                     currentIndex = nextIndex;
                 }else{
                     cost = C[nextIndex];
                 }
            }else{
                currentIndex = nextIndex;
            }
            nextIndex++;

        }
        return cost;

    }

}
