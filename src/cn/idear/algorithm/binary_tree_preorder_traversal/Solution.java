package cn.idear.algorithm.binary_tree_preorder_traversal;

import cn.idear.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdongwei on 9/11/15.
 * Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            /**
             * 访问根节点。
             */
            result.add(curNode.val);
            /**
             * 右子树入栈
             */
            if(curNode.right != null)
                stack.push(curNode.right);
            /**
             * 先访问左子树。
             */
            if(curNode.left != null)
                stack.push(curNode.left);
        }
        return result;
    }
}
