package com.vimit.leetcode.dp;

public class RobberProblem {
    public static void main(String[] args) {
        RobberProblem rp = new RobberProblem();
        System.out.println(rp.rob(new int[]{1,3,1}));
    }

    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][2];
        return getMaxMoney(nums, 0, memo, 0);

    }

    public int getMaxMoney(int[] nums, int isPrevRobs, int[][] memo, int index){
        if(index == nums.length) return 0;
        if(memo[index][isPrevRobs]!=0) return memo[index][isPrevRobs];
        int maxMoney = 0;
        if(isPrevRobs == 1){
            maxMoney =  getMaxMoney(nums, 0, memo, index+1);
        }else{
            maxMoney = Math.max(nums[index]+getMaxMoney(nums, 1, memo, index+1), getMaxMoney(nums, 0, memo, index+1)) ;
        }
        memo[index][isPrevRobs] = maxMoney;
        return memo[index][isPrevRobs];
    }
}
