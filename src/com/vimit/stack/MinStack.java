package com.vimit.stack;

import java.util.Stack;

class MinStack {

    public static void main(String[] args) {

    }

    /** initialize your data structure here. */
    Stack<Integer> normalStack;
    Stack<Integer> minStack;

    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        normalStack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        } else{
            int minValue =  Math.min(minStack.peek(), x);
            minStack.push(minValue);
        }

    }

    public void pop() {
        if(!normalStack.isEmpty()){
            normalStack.pop();
            minStack.pop();
        }

    }

    public int top() {
        if(!normalStack.isEmpty()) return normalStack.peek(); else return -1;
    }

    public int getMin() {
        if(!normalStack.isEmpty()) return minStack.peek(); else return -1;
    }

}