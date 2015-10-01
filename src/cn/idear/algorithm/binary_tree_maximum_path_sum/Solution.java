package cn.idear.algorithm.binary_tree_maximum_path_sum;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/30/15.
 */
public class Solution {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    private int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return 0;
        int leftValue = maxPathSumHelper(root);
        int rightValue = maxPathSumHelper(root.right);
        int result = root.val;
        if(leftValue > 0) result += leftValue;
        if(rightValue > 0) result += rightValue;
        max = Math.max(max, result);
        return root.val + Math.max(0, Math.max(leftValue, rightValue));
    }
}
