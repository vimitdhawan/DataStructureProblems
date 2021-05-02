package com.vimit.crackig.coding.moderate;

class SubSort {
    public static void main(String[] args) {
        SubSort subSort = new SubSort();
        System.out.println(subSort.findUnsortedSubarray(new int[]{1,3,2,2,2}));
    }
    public int findUnsortedSubarray(int[] nums) {

        int leftIndex = findLeftIndex(nums);

        if(leftIndex ==  nums.length-1) return 0;
        int rightIndex = findRightIndex(nums);

        int minIndex = leftIndex;
        int maxIndex = rightIndex;


        for(int t = leftIndex; t<=rightIndex; t++){
            if(nums[t]<nums[minIndex]){
                minIndex = t;
            }
            if(nums[t]>nums[maxIndex]){
                maxIndex = t;
            }
        }

        int updatedLeftIndex = getLeftSortIndex(nums,nums[minIndex],leftIndex);
        int updatedRightIndex = getRightSortIndex(nums,nums[maxIndex],rightIndex);


        return updatedRightIndex+1-updatedLeftIndex;

    }

    public int findLeftIndex(int[] nums){
        int i =0;
        while(i<nums.length-1){
            if(nums[i]>nums[i+1]){
                break;
            }
            i++;
        }
        return i;
    }

    public int findRightIndex(int[] nums){
        int j = nums.length -1;
        while(j>=1){
            if(nums[j]<nums[j-1]){
                break;
            }
            j--;
        }
        return j;
    }

    public int getLeftSortIndex(int[] nums, int minValue, int leftIndex){
        while(leftIndex-1>=0){
            if(nums[leftIndex-1]<=minValue){
                break;
            }
            leftIndex--;
        }
        return leftIndex;
    }

    public int getRightSortIndex(int[] nums, int maxValue, int rightIndex){
        while(rightIndex+1<nums.length){
            if(nums[rightIndex+1]>=maxValue){
                break;
            }
            rightIndex++;
        }
        return rightIndex;
    }
}
