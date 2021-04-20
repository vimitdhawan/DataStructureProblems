package com.vimit.crackig.coding.sorted;
import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"abc", "cab", "def"});
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsGroup = new HashMap<>();
        for(int i =0; i<strs.length; i++){
            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String sorted =  new String(tempArray);
            addElement(anagramsGroup, sorted, strs[i]);
        }
        return  anagramsGroup.values().stream().collect(Collectors.toList());

    }

    public void addElement(Map<String, List<String>> anagramsGroup, String sorted, String original){
        if(anagramsGroup.containsKey(sorted)){
            List<String> anagrams = anagramsGroup.get(sorted);
            anagrams.add(original);
        } else{
            List<String> anagrams = new ArrayList<>();
            anagrams.add(original);
            anagramsGroup.put(sorted, anagrams);
        }
    }
}
