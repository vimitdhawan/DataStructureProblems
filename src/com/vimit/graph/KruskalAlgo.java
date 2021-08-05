package com.vimit.graph;

import java.util.*;
public class KruskalAlgo {
    public static void main(String[] args) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        for(List<String> acct: accounts){
            String ownerName = acct.get(0);
            for(int i =1; i<acct.size(); i++){
                parents.put(acct.get(i), acct.get(i));
                owners.put(acct.get(i), ownerName);
            }
        }
        for(List<String> acct: accounts){
            String parent = acct.get(1);
            for(int i =2; i<acct.size(); i++){
                parents.put(find(acct.get(i), parents), parent);
            }
        }
        for(List<String> acct: accounts){
            String parent = find(acct.get(1), parents);
            TreeSet<String> group = unions.getOrDefault(parent, new TreeSet<>());
            for(int i =1; i<acct.size(); i++){
                group.add(acct.get(1));
            }
            unions.put(parent, group);
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList();
            emails.add(owners.get(p));
            emails.addAll(unions.get(p));
            res.add(emails);
        }
        return res;

    }

    public String find(String maybeParent, Map<String, String> parents){
        return parents.get(maybeParent).equals(maybeParent)  ? maybeParent : find(parents.get(maybeParent), parents);
    }
}
