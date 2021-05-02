package com.vimit.crackig.coding.stack.queue;

import java.util.Scanner;
        import java.util.Stack;
public class SortStack {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Stack<Integer> s=new Stack<>();
            int n=sc.nextInt();
            while(n-->0)
                s.push(sc.nextInt());
            SortStackSol g=new SortStackSol();
            Stack<Integer> a=g.sort(s);
            while(!a.empty()){
                System.out.print(a.peek()+" ");
                a.pop();
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


/*Complete the function below*/
class SortStackSol {
    public Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> output = new Stack<>();
        while(!s.isEmpty()){
            int temp = s.pop();
            while(!output.isEmpty() && output.peek()>temp){
                s.push(output.pop());
            }
            output.push(temp);
        }

        return output;

    }
}