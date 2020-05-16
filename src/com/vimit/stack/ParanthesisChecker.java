package com.vimit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParanthesisChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String data = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isParanthesisValid = true;
            for(int t=0; t<data.length(); t++){
                if(data.charAt(t)=='{' || data.charAt(t)=='(' || data.charAt(t)=='['){
                    stack.push(data.charAt(t));
                } else{
                    if(!stack.isEmpty()) {
                        Character elem = stack.pop();
                        if(! ( (elem == '{' && data.charAt(t) == '}') || (elem == '(' && data.charAt(t) == ')') ||  (elem == '[' && data.charAt(t) == ']'))){
                            isParanthesisValid = false;
                            break;
                        }
                    } else {
                        isParanthesisValid = false;
                        break;
                    }


                }
            }
            if(stack.size()>0){
                isParanthesisValid = false;
            }

            if(isParanthesisValid) {
                System.out.println("balanced");
            }else {
                System.out.println("not balanced");
            }


            }

    }
}
