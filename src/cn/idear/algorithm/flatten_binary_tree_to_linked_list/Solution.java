package cn.idear.algorithm.flatten_binary_tree_to_linked_list;

import cn.idear.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by wangdongwei on 9/25/15.
 */
public class Solution {

    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        TreeNode tail = dummy;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            tail.right = node;
            tail = tail.right;
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null) {
                stack.push(node.left);
                /**
                 * 第一次没有写node.left = null，超时。
                 * 为什么？大概是因为equals？
                 */
                node.left = null;
            }
        }
    }


    /**
     * 超时，算法复杂度分析：
     * T(n) = 2T(n/2) + C
     * 由递归树可得，复杂度为O(\log n)
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        flattenHelper(dummy, root);
    }

    private void flattenHelper(TreeNode dummy,  TreeNode root) {
        if(root == null)
           return;
        if(root.right != null)
            flattenHelper(dummy, root.right);
        if(root.left != null)
            flattenHelper(dummy, root.left);
        root.right = dummy.right;
        /**
         * 细节很重要。root.left = null不能少
         */
        root.left = null;
        dummy.right = root;
    }
}
