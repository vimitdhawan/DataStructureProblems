package com.vimit.trie.problems;

import com.vimit.trie.creation.Trie;
import com.vimit.trie.creation.TrieNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordBoggle {
    static int M = 0;
    static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            String[] bog = br.readLine().split(" ");
             N = Integer.parseInt(bog[0]);
             M = Integer.parseInt(bog[1]);
            char[] boggle = br.readLine().replace(" ", "").toCharArray();
            char[][] boggleWord = new char[N][M];
            int p = 0;
            for (int j = 0; j < N; j++) {
                for (int t = 0; t < M; t++) {
                    boggleWord[j][t] = boggle[p];
                    p++;
                }
            }
            Trie trie = new Trie();
            for (int l = 0; l < str.length; l++) {
                trie.insert(str[l].toUpperCase());
            }
            boolean visited[][] = new boolean[N][M];
            boolean[] traverse = new boolean[26];
            List<String> res = new ArrayList<>();
            for (int a = 0; a < str.length; a++) {
                if (!traverse[str[a].charAt(0) - 'A']) {
                    for (int r = 0; r < N; r++) {
                        for (int q = 0; q < M; q++) {
                            if (str[a].charAt(0) == boggleWord[r][q]) {
                                if (trie.root.child[str[a].charAt(0) - 'A'] != null)
                                    getBoggle(trie.root.child[str[a].charAt(0) - 'A'], visited, boggleWord, r, q, res, str[a].substring(0,1));
                            }
                        }
                    }
                    traverse[str[a].charAt(0) - 'A'] = true;
                }
            }
            res.stream().sorted().distinct().forEach(a -> System.out.print(a+" "));
            System.out.println();
        }
    }

    private static void getBoggle(TrieNode trieNode, boolean[][] visited, char[][] boggleWord, int r, int q, List<String> res, String output) {
        if (trieNode.leaf) res.add(output);

        if (isSafe(r, q, visited)) {
            // make it visited
            visited[r][q] = true;

            // traverse all child of current root
            for (int K = 0; K < 26; K++) {
                if (trieNode.child[K] != null) {
                    // current character
                    char ch = (char) (K + 'A');

                    // Recursively search reaming character of word
                    // in trie for all 8 adjacent cells of
                    // boggle[i][j]
                    if (isSafe(r + 1, q + 1, visited)
                            && boggleWord[r + 1][q + 1] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r + 1, q + 1,
                                res, output + ch);
                    if (isSafe(r, q + 1, visited)
                            && boggleWord[r][q + 1] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r, q + 1,
                                res, output + ch);
                    if (isSafe(r - 1, q + 1, visited)
                            && boggleWord[r - 1][q + 1] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r-1, q + 1,
                                res, output + ch);
                    if (isSafe(r + 1, q, visited)
                            && boggleWord[r + 1][q] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r+1, q,
                                res, output + ch);
                    if (isSafe(r + 1, q - 1, visited)
                            && boggleWord[r + 1][q - 1] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r+1, q-1,
                                res, output + ch);
                    if (isSafe(r, q - 1, visited)
                            && boggleWord[r][q - 1] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r, q-1,
                                res, output + ch);
                    if (isSafe(r - 1, q - 1, visited)
                            && boggleWord[r - 1][q - 1] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r-1, q-1,
                                res, output + ch);
                    if (isSafe(r - 1, q, visited)
                            && boggleWord[r - 1][q] == ch)
                        getBoggle(trieNode.child[K], visited, boggleWord,
                                r-1, q,
                                res, output + ch);
                }
            }

            // make current element unvisited
            visited[r][q] = false;
        }


    }

    private static boolean isSafe(int i, int j, boolean visited[][]) {
        return (i >= 0 && i < N && j >= 0
                && j < M && !visited[i][j]);
    }
}
