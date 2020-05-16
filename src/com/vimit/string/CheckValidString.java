package com.vimit.string;

/*Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

        Any left parenthesis '(' must have a corresponding right parenthesis ')'.
        Any right parenthesis ')' must have a corresponding left parenthesis '('.
        Left parenthesis '(' must go before the corresponding right parenthesis ')'.
        '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
        An empty string is also valid.*/


import java.util.Stack;

public class CheckValidString {
    public static void main(String[] args) {
        String s = "";
        boolean res = checkValidString(s);
        System.out.println(res);

    }

    public static boolean checkValidString(String s) {

        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> bracketStack = new Stack<>();

        char[] arr = s.toCharArray();

        for(int i =0; i<s.length(); i++){
            if(arr[i] == '('){
                bracketStack.push(i);
            } else if(arr[i]=='*'){
                starStack.push(i);
            } else{
                if(!bracketStack.isEmpty()){
                    bracketStack.pop();
                } else if(!starStack.isEmpty()){
                    starStack.pop();
                } else{
                    return false;
                }
            }
        }

        while(!bracketStack.isEmpty()){
            int bracketPop = bracketStack.pop();
            if(!starStack.isEmpty()){
                int starStackPop = starStack.pop();
                if(bracketPop>starStackPop){
                    return false;
                }
            } else{
                return false;
            }



        }

        return true;

    }
}
