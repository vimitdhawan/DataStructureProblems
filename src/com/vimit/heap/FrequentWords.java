package com.vimit.heap;

import java.util.*;

class FrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordFrequency> map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word)){
                map.get(word).increment();
            }else{
                map.put(word, new WordFrequency(word, 1));
            }
        }
        PriorityQueue<WordFrequency> heap = new PriorityQueue<>( (a, b) -> {
            if(a.count == b.count){
                return a.word.compareTo(b.word);
            }
            return -a.count.compareTo(b.count);
        });

        for(WordFrequency wf: map.values()){
            heap.offer(wf);
        }
        List<String> res = new ArrayList<>();
        for(int i =0; i<k; i++){
            res.add(heap.poll().word);
        }

        return res;
    }
}

class WordFrequency {
    String word;
    Integer count;
    WordFrequency(String word, Integer count){
        this.word = word;
        this.count = count;
    }

    public void increment(){
        this.count++;
    }

}
