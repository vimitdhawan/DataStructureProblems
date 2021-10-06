package com.vimit.interview.amazon;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.print(s1.groupTransactions(Arrays.asList("vimit", "vimit", "dhawan")));

    }

    public  static List<String> groupTransactions(List<String> transactions) {
        List<String> transactionsGroup = new ArrayList<>();
        Map<String, Integer> transactionsCount  =  getTransactionsCount(transactions);
        List<Transaction> uniqueTransactions = transactionsCount.entrySet().stream().map(entry -> new Transaction(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        Collections.sort(uniqueTransactions, (t1, t2) -> {
            if (t1.count == t2.count) {
                return t1.name.compareTo(t2.name);
            }
            return t2.count.compareTo(t1.count);
        });
        for(Transaction transaction: uniqueTransactions){
            String transactionGroup = transaction.name+ " " +transaction.count;
            transactionsGroup.add(transactionGroup);
        }
        return transactionsGroup;
    }

    public  static Map<String, Integer> getTransactionsCount(List<String> transactions){
        Map<String, Integer> transactionsCount = new HashMap<>();
        for(String transaction: transactions){
            transactionsCount.put(transaction, transactionsCount.getOrDefault(transaction, 0)+1);
        }
        return transactionsCount;
    }


}

class Transaction{
    String name;
    Integer count;
    Transaction(String name, Integer count){
        this.name = name;
        this.count = count;
    }
}
