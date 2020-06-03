package com.vimit.coursera.string;

import java.io.*;
import java.util.*;

/*class Node
{
    public static final int Letters =  4;
    public static final int NA      = -1;
    public int next [];
    public boolean patternEnd;

    Node ()
    {
        next = new int [Letters];
        Arrays.fill (next, NA);
        patternEnd = false;
    }
}*/

public class TrieMatchingExtended implements Runnable {
    int letterToIndex (char letter)
    {
        switch (letter)
        {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: assert (false); return Node.NA;
        }
    }

    List <Integer> solve (String text, int n, List <String> patterns) {
        List <Integer> result = new ArrayList <Integer> ();
        List<Map<Character, Integer>>  trie = buildTrie(patterns.toArray(new String[patterns.size()]));
        for(int i =0; i<text.length(); i++){
            Map<Character, Integer> node = trie.get(0);
            int trieIndex = i ;
            while(trieIndex<text.length()){
                Character trieChar = text.charAt(trieIndex);
                if(node.containsKey(trieChar)){
                    node = trie.get(node.get(trieChar));
                    if(node.size()==0){
                        result.add(i);
                        break;
                    }
                    if(node.containsKey('$') && !result.contains(i)){
                        result.add(i);
                    }
                    trieIndex++;
                } else {
                    break;
                }
            }
        }

        // write your code here

        return result;
    }


    List<Map<Character, Integer>> buildTrie(String[] patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<Map<Character, Integer>>();
        trie.add(new HashMap<Character, Integer>());
        for(int i=0; i<patterns.length; i++){
            Map<Character, Integer> node = trie.get(0);
            for(int j=0; j<patterns[i].length(); j++){
                Character value = patterns[i].charAt(j);
                if(node.containsKey(value)){
                    node = trie.get(node.get(value));
                } else {
                    trie.add(new HashMap<Character, Integer>());
                    node.put(value, trie.size() - 1);
                    node = trie.get(trie.size() - 1);
                }
            }
            node.put('$',-1);
        }
        // write your code here

        return trie;
    }

    public void run () {
        try {
            BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
            String text = in.readLine ();
            int n = Integer.parseInt (in.readLine ());
            List <String> patterns = new ArrayList <String> ();
            for (int i = 0; i < n; i++) {
                patterns.add (in.readLine ());
            }

            List <Integer> ans = solve (text, n, patterns);

            for (int j = 0; j < ans.size (); j++) {
                System.out.print ("" + ans.get (j));
                System.out.print (j + 1 < ans.size () ? " " : "\n");
            }
        }
        catch (Throwable e) {
            e.printStackTrace ();
            System.exit (1);
        }
    }

    public static void main (String [] args) {
        new Thread (new TrieMatchingExtended ()).start ();
    }
}

