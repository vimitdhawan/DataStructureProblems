package com.vimit.leetcode.design;

import java.util.*;
class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);
        System.out.print(set.getRandom());
    }

    private  Map<Integer, Integer> randoms;
    private  List<Integer> nums;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        randoms = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!randoms.containsKey(val)){
            randoms.put(val, nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randoms.containsKey(val)){
            int index = randoms.remove(val);
            if (index < nums.size() - 1 ) { // not the last one than swap the last one with this val
                int lastone = nums.get(nums.size() - 1 );
                nums.set( index , lastone );
                randoms.put(lastone, index);
            }
            nums.remove(nums.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */