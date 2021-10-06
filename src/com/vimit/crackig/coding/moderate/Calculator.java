package com.vimit.crackig.coding.moderate;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.calculate("2-3+4"));
    }

    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int previousValue = 0;
        for(char currentChar: s.toCharArray()){
            if(currentChar == 32) continue;
            if(Character.isDigit(currentChar)){
                previousValue = previousValue * 10 + Integer.parseInt(String.valueOf(currentChar));
            }else{
                numbers.push(previousValue);
                previousValue = 0;
                if (!operators.isEmpty()) {
                    while (checkCollapse(operators, currentChar)) {
                        int value1 = numbers.pop();
                        int value2 = numbers.pop();
                        int result = applyOperation(value2, value1, operators.pop());
                        numbers.push(result);
                    }
                }
                operators.push(currentChar);
            }
        }
        while(!numbers.isEmpty()){
            previousValue = applyOperation(numbers.pop(), previousValue, operators.pop());
        }
        return previousValue;

    }

    private boolean checkCollapse(Stack<Character> operators , char currentOperator){
        if(operators.isEmpty()) return false;
        char operatorTop = operators.peek();
        if((currentOperator == '*' || currentOperator == '/') && (operatorTop == '+' || operatorTop == '-') ) return false;
        return true;
    }

    private int applyOperation(int value1 , int value2, char operation){
        if(operation == '+') return value1+value2;
        if(operation == '-') return value1-value2;
        if(operation == '*') return value1*value2;
        else return value1/value2;
    }
}
