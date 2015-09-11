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
    private enum ReturnType{
        PRE, POST, IN, DONE
    }
    private class State{
        ReturnType returnType = ReturnType.PRE;
        TreeNode node;

        public State(TreeNode node) {
            this.node = node;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<State> stack = new Stack<>();
        if(root != null)
            stack.push(new State(root));
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            State state = stack.pop();
            switch (state.returnType){
                case PRE:
                    result.add(state.node.val);
                    state.returnType = ReturnType.IN;

                case IN:
                    state.returnType = ReturnType.POST;
                    if(state.node.left != null){
                        stack.push(state);
                        stack.push(new State(state.node.left));
                        continue;
                    }

                case POST:
                    state.returnType = ReturnType.DONE;
                    if(state.node.right != null){
                        stack.push(new State(state.node.right));
                    }

                default:
                    break;
            }
        }
        return result;
    }
    public List<Integer> preorderTraversal1(TreeNode root) {
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


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root, result);
        return result;
    }

    private void preorderTraversalHelper(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        /**
         * 先访问根节点
         */
        result.add(root.val);
        /**
         * 访问左子树
         */
        preorderTraversalHelper(root.left, result);
        /**
         * 访问右子树
         */
        preorderTraversalHelper(root.right, result);
    }
}
