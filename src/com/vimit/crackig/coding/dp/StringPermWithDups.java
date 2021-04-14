package com.vimit.crackig.coding.dp;

import java.util.*;

public class StringPermWithDups {
    public static void main(String[] args) {
        StringPermWithDups sp = new StringPermWithDups();
        System.out.println(sp.getPermutation("aab").toString());

    }

    ArrayList<String> getPermutation(String s) {
        ArrayList<String> result =new ArrayList<String>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    private void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if (remaining== 0) {
            result.add(prefix);
            return;
        }
        for (Character c : map.keySet()) {
            int count= map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
       }
    }

    private HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

}
