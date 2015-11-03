package cn.idear.algorithm.invert_binary_tree;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
}
