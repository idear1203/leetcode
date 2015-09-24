package cn.idear.algorithm.construct_binary_tree_from_inorder_and_postorder_traversal;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/24/15.
 */
public class Solution {
    int p ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length - 1;
        return buildTreeHelper(inorder, postorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end) {
        if(start >= end)
            return null;
        int rootVal = postorder[p--];
        TreeNode root = new TreeNode(rootVal);
        int i ;
        for(i = start; inorder[i] != rootVal; i++);
        root.right = buildTreeHelper(inorder, postorder, i + 1, end);
        root.left = buildTreeHelper(inorder, postorder, start, i);
        return root;
    }
}
