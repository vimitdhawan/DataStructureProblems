package com.vimit.crackig.coding.stack.queue;

import java.util.*;
class Get_Min_From_Stack
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int q = sc.nextInt();
            GfG g = new GfG();
            while(q>0)
            {
                int qt = sc.nextInt();

                if(qt == 1)
                {
                    int att = sc.nextInt();
                    g.push(att);
                    //System.out.println(att);
                }
                else if(qt == 2)
                {
                    System.out.print(g.pop()+" ");
                }
                else if(qt == 3)
                {
                    System.out.print(g.getMin()+" ");
                }

                q--;
            }
            System.out.println();
            T--;
        }

    }
}


// } Driver Code Ends


class GfG
{
    Stack<Integer> s = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
        if(!minStack.isEmpty()) return minStack.peek();
        return -1;
        // Your code here
    }

    /*returns poped element from stack*/
    int pop()
    {
        if(!s.isEmpty()){
            minStack.pop();
            return s.pop();
        }

        return -1;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        s.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else if(x<minStack.peek()){
            minStack.push(x);
        }else{
            minStack.push(minStack.peek());
        }

    }
}


