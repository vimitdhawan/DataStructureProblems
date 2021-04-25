package com.vimit.crackig.coding.tree;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int totalCount = 0;
        totalCount = totalCount + getPathSum(root, targetSum, 0);
        return totalCount + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int getPathSum(TreeNode root, int targetSum, int currrentSum) {
        if(root == null) return 0;
        currrentSum = currrentSum + root.val;
        int count = 0;
        if(currrentSum == targetSum){
            count++;
        }
        count =  count + getPathSum(root.left, targetSum, currrentSum) + getPathSum(root.right, targetSum, currrentSum);
        return count;


    }
}