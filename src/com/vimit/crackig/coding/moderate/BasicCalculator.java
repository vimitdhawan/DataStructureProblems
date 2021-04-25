package com.vimit.crackig.coding.moderate;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("(3+(12+4)-5"));
    }
    static int index = 0;
    public static int calculate(String s) {
        int result = 0;
        int sign = 1;
        while(index < s.length()) {
            char c = s.charAt(index++);
            if(Character.isDigit(c)) {
                int num = c - '0';
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                result += num * sign;
            } else if(c == '(') {
                result += sign * calculate(s);
                sign = 1;
            } else if(c == ')') return result;
            else if(c == '+') sign = 1;
            else if(c == '-') sign = -1;
        }

        return result;
    }
}


