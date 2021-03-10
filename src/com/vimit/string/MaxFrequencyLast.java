package com.vimit.string;
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class MaxFrequencyLast {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            sc.nextLine();
            MaxSolution obj = new MaxSolution();
            String arr[]=sc.nextLine().split(" ");
            System.out.println(obj.mostFrequentWord(arr, n));

        }
    }
}

class trie_element {

    public trie_element nxt[];
    public int count;
    public int first_appearance;

    public trie_element() {
        count = 0;
        nxt=new trie_element[26];
        for (int i = 0; i < 26; i++)
            nxt[i] = null;
    }
};

// } Driver Code Ends
//User function Template for Java

class MaxSolution
{
    private static class IndexDetail{
        public  int count;
        public int index;
        IndexDetail(int count,int index ){
            this.index = index;
            this.count = count;
        }
    }
    public String mostFrequentWord(String arr[],int n)
    {
        Map<String, IndexDetail> map = new HashMap<>();
        String maxWord = "";
        int maxCount =0;
        int currentIndex=0;
        for(int i =0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                IndexDetail detail = map.get(arr[i]);
                detail.count = detail.count+1;
                map.put(arr[i],detail);
            } else {
                map.put(arr[i], new IndexDetail(1, i));
            }
            if((map.get(arr[i]).count>maxCount) || ((map.get(arr[i]).count == maxCount) && (map.get(arr[i]).index>currentIndex))){
                maxWord = arr[i];
                maxCount = map.get(arr[i]).count;
                currentIndex = map.get(arr[i]).index;
            }
        }
        return maxWord;
    }


}


// { Driver Code Starts.  // } Driver Code Ends

