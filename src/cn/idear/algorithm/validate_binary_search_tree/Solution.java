package cn.idear.algorithm.validate_binary_search_tree;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/20/15.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, false, Integer.MIN_VALUE, false, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, boolean hasMin, int minValue, boolean hasMax, int maxValue) {
        if(root == null)
            return true;
        if(hasMin && root.val <= minValue)
            return false;
        if(hasMax && root.val >= maxValue)
            return false;
        return isValidBSTHelper(root.left, hasMin, minValue, true, root.val)
                && isValidBSTHelper(root.right, true, root.val, hasMax, maxValue);
    }

    public boolean isValidBST1(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.left) || !isValidBST(root.right))
            return false;
        if(root.left != null){
            for(TreeNode rightMost = root.left; rightMost != null; rightMost = rightMost.right){
               if(rightMost.val >= root.val)
                   return false;
            }
        }
        if(root.right != null){
            for(TreeNode leftMost = root.right; leftMost != null; leftMost = leftMost.left){
                if(leftMost.val <= root.val)
                    return false;
            }
        }
        return true;
    }
}
