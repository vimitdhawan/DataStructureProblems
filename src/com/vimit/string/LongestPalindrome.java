package com.vimit.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // taking input of number of testcase
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int n = input.length();
            Integer memo[][] = new Integer[n][n];
            Map<Integer, Integer> map = new HashMap<>();
            int res = findLPSLengthRecursive(memo, input,0, n-1, map);
            System.out.println(input.substring(map.get(res), map.get(res)+res));

        }

    }

    private static int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex, Map<Integer, Integer> map) {
        if (startIndex > endIndex)
            return 0;
        if (startIndex == endIndex)
            return 1;

        if (dp[startIndex][endIndex] == null) {
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                int remainingLength = endIndex - startIndex - 1;
                if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1, map)) {
                    dp[startIndex][endIndex] = remainingLength + 2;
                    map.put( dp[startIndex][endIndex], startIndex);
                    return dp[startIndex][endIndex];
                }
            }
            int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex, map);
            int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1, map);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }

        return dp[startIndex][endIndex];
    }
}
