package cn.idear.algorithm.lowest_common_ancestor_of_a_binary_tree;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) return root;
        TreeNode left = null, right = null;
        if(root.left != null)
            left = lowestCommonAncestor(root.left, p, q);
        if(root.right != null)
            right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right == null)
            return left;
        if(right != null && left == null)
            return right;
        return left == null ? null : root;
    }
}
