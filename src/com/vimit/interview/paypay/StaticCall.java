package com.vimit.interview.paypay;

public class StaticCall {
    public static void main(String[] args) {
        String a = "vimit";
        System.out.println(a.substring(0,1));
        Shape s1 = new Circle();
        s1.shape();
    }

}

class Shape{
    public static void shape(){
        System.out.println("shape");
    }
}

class Circle extends Shape{
    public static void shape(){
        System.out.println("circle");
    }
}