package com.vimit.crackig.coding.ArrayString;

public class StringRotation {
    public static void main(String[] args) {
        StringRotation sr = new StringRotation();
        System.out.println(sr.rotateString("vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg", "fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf"));
    }

    public boolean rotateString(String A, String B) {
        A = A+A;
        int k=0;
        int startOffset = 0;
        boolean isFound = false;
        for(int i=0; i<A.length(); i++){
            if(k == B.length()-1){
                return true;
            }else{
                if(A.charAt(i) == B.charAt(k)){
                    if(!isFound){
                        isFound = true;
                        startOffset = i;
                    }
                    k++;
                }else{
                    if(isFound){
                        isFound = false;
                        i = startOffset;
                        k=0;
                    }
                }
            }
        }
        return false;
    }
}
