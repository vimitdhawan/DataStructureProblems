package com.vimit.crackig.coding.hard;

public class HistogramVolume {
    public static void main(String[] args) {
        int a = 2147483647;
        System.out.print(a+1);
        HistogramVolume  vol = new HistogramVolume();
        int res = vol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(res);
    }

    public int trap(int[] height) {
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int sum =0;
        left[0] = height[0];
        right[size-1] = height[size-1];
        for(int i = 1; i<height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        for(int j = height.length-2; j>=0; j--){
            right[j] = Math.max(height[j], right[j+1]);
        }
        for(int k =1; k<height.length-1; k++){
            int boundary = Math.min(left[k], right[k]);
            sum = sum + Math.abs(height[k] - boundary);
        }
        return sum;
    }

}
