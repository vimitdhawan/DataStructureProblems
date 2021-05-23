package com.vimit.interview.ByteDance;

import java.io.*;
import java.util.*;


class Result {

    class Item {
        int index;
        int value;
        Item(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    /*
     * Complete the 'findBestMoviePair' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY movieDurations
     *  2. INTEGER flightDuration
     */

    public  List<Integer> findBestMoviePair(List<Integer> movieDurations, int flightDuration) {
        List<Item> items = new ArrayList<>();
        for(int i =0; i<movieDurations.size(); i++){
            items.add(new Item(i, movieDurations.get(i)));
        }
        Collections.sort(items, Comparator.comparingInt((Item i) -> i.value));
        int start = 0;
        int end = movieDurations.size()-1;
        int maxValue = 0;
        int firstMovie = 0;
        int lastMovie = 0;
        while(start<end){
            int bothMovies = items.get(start).value+items.get(end).value;
            if(bothMovies <= flightDuration){
                if(bothMovies>maxValue){
                    maxValue = bothMovies;
                    firstMovie = start;
                    lastMovie = end;
                }
                start++;
            }else{
                end--;
            }
        }
        List<Integer> output = new ArrayList<>();
        output.add(firstMovie);
        output.add(lastMovie);

        // Write your code here
        return output;
    }

}

class Solution {

    public static void main(String[] args) throws IOException {
        List<Integer> movieDurations = Arrays.asList(90, 85, 75, 60, 120, 150, 125);
        int flightDuration  = 250;
        Result res = new Result();
        List<Integer> result = res.findBestMoviePair(movieDurations, flightDuration);
        System.out.println(result.get(0)  +" "+ result.get(1));

    }


}


// two movies atleast
// sum <= n
// maintain index
//
//
// 70, 90, 80, 160, 150

// (70, 0).. 90(1)

// 70 0 , 80 1, 90 2, ......  110, 120, 150, 200


// O(n**n) O(1)
// O(nlogn) O(n)
// O(n)
