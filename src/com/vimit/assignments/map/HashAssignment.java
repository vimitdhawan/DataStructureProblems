package com.vimit.assignments.map;

import java.util.*;

public class HashAssignment {

    public static void main(String args[]) {
        List<List<Integer>> intLists = new LinkedList<>();

        intLists.add(new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(15, 24, 50, 12, 3, 9)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(78, 65, 24, 13, 9, 3, 12)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(15, 78, 14, 3, 2, 9, 44, 12)));

        List<Integer> intResult = findCommonElements(intLists);

        System.out.println("Common elements of the integer list");
        System.out.println(intResult + "\n");

        List<List<String>> stringLists = new LinkedList<>();

        stringLists.add(new ArrayList<String>(Arrays.asList("a", "b", "d", "c", "h", "e")));
        stringLists.add(new ArrayList<String>(Arrays.asList("g", "b", "e", "j", "u", "z", "h", "d")));
        stringLists.add(new ArrayList<String>(Arrays.asList("y", "p", "b", "d")));

        List<String> stringResult = findCommonElements(stringLists);

        System.out.println("Common elements of the string list");
        System.out.println(stringResult);
    }

    public static <T> List<T> findCommonElements(List<List<T>> collections) {
        Iterator<List<T>> collectionIterator = collections.iterator();
        if(!collectionIterator.hasNext()) return new ArrayList<>();
        if(collections.size() == 1) return collectionIterator.next();
        Set<T> currentContainer = new HashSet<>(collectionIterator.next());
        while(collectionIterator.hasNext()){
            if(currentContainer.isEmpty()){
                break;
            }
            List<T> currentCollection = collectionIterator.next();
            Set<T> tempContainer = new HashSet<>();
            for(T elem: currentCollection) {
                if(currentContainer.contains(elem)){
                    tempContainer.add(elem);
                }
            }
            currentContainer = tempContainer;
        }
        return new ArrayList<>(currentContainer);
    }
}
