package com.vimit.crackig.coding.hard;


import java.util.*;

public class WordTransformer {

    /* find path to transform startWord into endWord. */
    public static int transform(String startWord, String targetWord, String[] wordList) {

        if(startWord == targetWord)
            return 1;
        Set<String> D = new HashSet<>();
        for(int i =0; i<wordList.length; i++){
            D.add(wordList[i]);
        }

        if (!D.contains(targetWord))
            return 0;

        // To store the current chain length
        // and the length of the words
        int level = 0, wordlength = startWord.length();

        // Push the starting word into the queue
        Queue<String> Q = new LinkedList<>();
        Q.add(startWord);

        // While the queue is non-empty
        while (!Q.isEmpty())
        {
            ++level;
            int sizeofQ = Q.size();

            for (int i = 0; i < sizeofQ; ++i)
            {
                char []word = Q.peek().toCharArray();
                Q.remove();
                for (int pos = 0; pos < wordlength; ++pos)
                {
                    char orig_char = word[pos];

                    for (char c = 'a'; c <= 'z'; ++c)
                    {
                        word[pos] = c;
                        if (String.valueOf(word).equals(targetWord))
                            return level + 1;
                        if (!D.contains(String.valueOf(word)))
                            continue;
                        D.remove(String.valueOf(word));

                        Q.add(String.valueOf(word));
                    }
                    word[pos] = orig_char;
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
        int list = transform("tree", "flat", words);

        if (list == 0) {
            System.out.println("No path.");
        } else {
            System.out.println(list);
        }
    }

}


