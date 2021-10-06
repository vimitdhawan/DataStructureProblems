package com.vimit.leetcode.Array;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogsSort {
    public static void main(String[] args) {

    }
    public String[] reorderLogFiles(String[] logs) {
        return Stream.concat(Arrays.stream(logs).filter(log -> Character.isLetter(log.indexOf(" ")+1)).sorted((a, b) -> {
                      String contentA = a.substring(a.indexOf(" "));
                      String contentB = b.substring(b.indexOf(" "));
                      if(contentA.equals(contentB)) return contentA.compareTo(contentB);
                      else return a.compareTo(b);
                }), Arrays.stream(logs).filter(log -> Character.isDigit(log.indexOf(" ")+1))).collect(Collectors.toList()).toArray(new String[logs.length]);

    }
}
