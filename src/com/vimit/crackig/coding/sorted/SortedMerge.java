package com.vimit.crackig.coding.sorted;



public class SortedMerge {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = nums2.length-1;
        int j = nums1.length-2-i;
        int holdElement = nums1.length-1;
        while(i>=0 && j>=0){
            if(nums1[j]>nums2[i]){
                nums1[holdElement] = nums1[j];
                j--;
            }else{
                nums1[holdElement] = nums2[i];
                i--;
            }
            holdElement--;
        }
        while(i>=0){
            nums1[holdElement] = nums2[i];
            i--;
            holdElement--;
        }
        while(j>=0){
            nums1[holdElement] = nums1[j];
            j--;
            holdElement--;
        }

    }
}
