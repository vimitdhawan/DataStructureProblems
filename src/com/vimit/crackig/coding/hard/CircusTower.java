package com.vimit.crackig.coding.hard;

import java.util.*;

public class CircusTower {
    private class HeightWeight implements Comparable<HeightWeight>{
        int height;
        int weight;
        HeightWeight(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(HeightWeight other) {
            if(this.height == other.height){
                return this.weight - other.weight;
            }else{
                return this.height - other.height;
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1},{1,7},{1,9},{2,2},{2,6},{3,3},{3,5},{4,4}};
        CircusTower ct = new CircusTower();
       System.out.println(ct.getMaxHeightTower(arr));
    }

    public int getMaxHeightTower(int[][] arr){
        List<HeightWeight> list = new ArrayList<>();
        int i =0;
        for(i =0; i<arr.length; i++){
            list.add(new HeightWeight(arr[i][0], arr[i][1]));
        }
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for(i =0; i<list.size(); i++){
            HeightWeight current = list.get(i);
            if(!map.containsKey(current.height)){
                map.put(current.height, current.weight);
            }
        }
        int[] nums = map.values().stream().mapToInt(Integer::intValue).toArray();
        return getLIS(nums);
    }

    public int getLIS(int[] nums){

        int _l = nums.length;
        int[] out = new int[_l];
        int mx = Integer.MIN_VALUE;

		/*
		we initialize the array with ones because
		a single character has a subsequence of length one
		*/
        Arrays.fill(out, 1);

        for(int i = 0; i < _l; i++)

            for(int j = i + 1; j < _l; j++){
				/*
				every iteration, all we're doing is checking what is the longest
				increasing subsequence so far, till this point
				*/
                if(nums[j] > nums[i])
                    out[j] = Math.max(out[j], out[i] + 1);

				/*
				we keep checking for a max value because the longest
				subsequence could exist before the end of the string
				*/
                mx = Math.max(out[j], mx);
            }

        return mx == Integer.MIN_VALUE ? 1 : mx;
    }


}


