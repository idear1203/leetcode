package cn.idear.algorithm.sum_root_to_leaf_numbers;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return sumNumbersHelper(root, root.val);
    }

    private int sumNumbersHelper(TreeNode root, int cur){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return cur;
        else if(root.left == null)
            return sumNumbersHelper(root.right, cur * 10 + root.right.val);
        else if(root.right == null)
            return sumNumbersHelper(root.left, cur * 10 + root.left.val);
        else{
            return sumNumbersHelper(root.left, cur * 10 + root.left.val) +
                    sumNumbersHelper(root.right, cur * 10 + root.right.val);
        }
    }
}
