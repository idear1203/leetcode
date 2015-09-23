package cn.idear.algorithm.construct_binary_tree_from_preorder_and_inorder_traversal;

import cn.idear.algorithm.util.TreeNode;

import java.util.Arrays;

/**
 * Created by wangdongwei on 9/24/15.
 */
public class Solution {
    int rootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end) {
        if(start >= end)
            return null;
        int rootVal = preorder[rootIndex++];
        int index;
        for(index = start; inorder[index] != rootVal; index++);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, inorder, start, index);
        root.right = buildTreeHelper(preorder, inorder, index + 1, end);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        int rootVal = preorder[0];
        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftLen = index;
        TreeNode root = new TreeNode(rootVal);
        TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + leftLen),
                Arrays.copyOfRange(inorder, 0, leftLen));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder, 1 + leftLen, preorder.length),
                Arrays.copyOfRange(inorder, leftLen + 1, inorder.length));
        root.left = left;
        root.right = right;
        return root;
    }
}
