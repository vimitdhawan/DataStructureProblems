package com.vimit.crackig.coding.moderate;

public class MasterMindGame {

    public static void main(String[] args) {
        Color[] guess = new Color[]{Color.BLUE, Color.RED, Color.RED};
        Color[] solution = new Color[]{Color.RED, Color.BLUE, Color.RED};
        Result res = findHitAndPseudoHit(guess, solution);
        System.out.println(res.getHit());
        System.out.println(res.getPseudoHit());
    }


public static Result findHitAndPseudoHit(Color[] guess, Color[] input){
    Result result = new Result();
    int[] frequency = new int[4];
    for(int i =0; i<guess.length; i++){
        if(guess[i].equals(input[i])){
            result.incrementHit();
        } else{
            frequency[input[i].getValue()]++;
        }
    }

    for(int t=0; t<guess.length; t++ ){
        if(frequency[guess[t].getValue()]>0 && !guess[t].equals(input[t])){
            result.incrementPseudoHit();
            frequency[guess[t].getValue()]--;
        }
    }

    return result;

 }
}
enum Color{
    RED(0), GREEN(1), BLUE(2), YELLOW(3);
    int value;
    Color(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}

class Result{
    private int hit;
    private int pseudoHit;

    public int getHit() {
        return hit;
    }

    public void incrementHit() {
        this.hit = hit + 1;
    }

    public int getPseudoHit() {
        return pseudoHit;
    }

    public void incrementPseudoHit() {
        this.pseudoHit = pseudoHit+1;
    }

}
