package com.vimit.hashing;
import java.util.*;
public class SortingArrFrequency {
  
  public static void main(String[] args){
      int arr[] = {5,5,4,6,4};
      List<Integer> finalArray = new ArrayList<Integer>();
      finalArray = sortArrayFrequencyHelper(arr, finalArray);
      for(Integer num: finalArray){
        System.out.print(num);
      }
  }
  
  public static List<Integer> sortArrayFrequencyHelper(int arr[] , List<Integer> finalArray){
  
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  for (int i = 0; i<arr.length; i++){
    if(map.containsKey(arr[i])){
      map.put(arr[i],map.get(arr[i]) + 1);
  }
    else{
      map.put(arr[i], 1);
    }                              
  finalArray.add(arr[i]);
  }
                                 
 Collections.sort(finalArray, new SortComparator(map));
 return finalArray;
}
}
class SortComparator implements Comparator<Integer> {
  private Map<Integer, Integer> frequencyMap;
  public SortComparator(Map<Integer, Integer> frequencyMap){
    this.frequencyMap = frequencyMap;
  }
  public int compare(Integer key1, Integer key2){
    int frequencyComparison = frequencyMap.get(key2).compareTo(frequencyMap.get(key1));
    
    if(frequencyComparison == 0){
      return +1;
    }
    else{
      return frequencyComparison;
    }
    
  }
}
