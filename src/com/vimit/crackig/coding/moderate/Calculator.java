package com.vimit.crackig.coding.moderate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
    System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    public static int calculate(String s) {
        Queue<Integer> leftElement = new LinkedList<>();
        Queue<Character> operators = new LinkedList<>();

        String input =  s.replaceAll("\\s", "");
        int i =1;
        int previous = Integer.valueOf(input.charAt(0)-'0');
        while(i<input.length()){
            if (Character.isDigit(input.charAt(i))) {
                previous = previous * 10 + input.charAt(i) - '0';
                i++;
                continue;
            }else if(input.charAt(i)=='*'){
                int element = Integer.valueOf(input.charAt(i+1)-'0');
                while(i+2<input.length() && Character.isDigit(input.charAt(i+2))){
                    element = element * 10 + input.charAt(i+2) - '0';
                    i++;
                }
                previous = previous * element;
            } else if(input.charAt(i)=='/'){
                int element = Integer.valueOf(input.charAt(i+1)-'0');
                while(i+2<input.length() && Character.isDigit(input.charAt(i+2))){
                    element = element * 10 + input.charAt(i+2) - '0';
                    i++;
                }
                previous = previous / element;
            } else{
                leftElement.add(previous);
                operators.add(input.charAt(i));
                previous = Integer.valueOf(input.charAt(i+1)-'0');
            }
            i = i+2;
        }

        int sum = 0;
        if(!leftElement.isEmpty())  sum = leftElement.remove(); else sum = previous;
        while(!operators.isEmpty()){
            int element =0;
            char operator = operators.remove();
            if(leftElement.isEmpty()){
                element = previous;
            }else {
                element = leftElement.remove();
            }
            if(operator == '+'){
                sum = sum + element;
            }else{
                sum = sum - element;
            }
        }
        return sum;
    }
}
