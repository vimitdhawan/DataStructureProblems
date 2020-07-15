package com.vimit.cache;

import java.io.*;
import java.util.*;
import java.lang.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    static int cap;
    private static Map<Integer, Integer> map;
    private static LinkedList<Integer> linkedList;
    LRUCache(int cap)
    {
        this.cap = cap;
        map = new HashMap<Integer, Integer>(cap);
        linkedList = new LinkedList<>();
        // Intialize the cache capacity with the given
        // cap
    }

    // This method works in O(1)
    public static int get(int key)
    {
        if(map.containsKey(key)){
            Integer a = key;
            linkedList.remove(a);
            linkedList.addFirst(a);
            return map.get(key);
        }
        return -1;
        // your code here
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        Integer a = key;
        linkedList.remove(a);
        map.remove(key);
        if(map.size()>=cap){
            int current = linkedList.removeLast();
            map.remove(current);
        }
        linkedList.addFirst(a);
        map.put(key, value);

    }

}
