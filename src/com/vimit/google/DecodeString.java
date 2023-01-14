package com.vimit.google;

public class DecodeString {
    int index = 0;
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[bc]"));
    }


    public String decodeString(String s) {
        String res = "";
        int number = 0;
        while(index < s.length()){
            char a = s.charAt(index);
            if(Character.isDigit(a)){
                number =  number * 10 + Integer.parseInt(String.valueOf(a));;
                index++;
            }else if(a == '['){
                index++;
                String temp  = decodeString(s);
                for(int i =0; i< number; i++){
                    res = res+temp;
                }
                number =0;
            }else if(a == ']'){
                index++;
                return res;
            } else{
                res =  res + a;
                index++;
            }

        }
        return res;

    }
}
