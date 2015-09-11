package cn.idear.algorithm.binary_tree_inorder_traversal;

import cn.idear.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdongwei on 9/9/15.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<State> stack = new Stack<>();
        if(root != null)
            stack.push(new State(root));
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
           State state = stack.pop();
            switch (state.returnType){
                case PRE:
                    state.returnType = ReturnType.IN;
                    if(state.node.left != null){
                        stack.push(state);
                        stack.push(new State(state.node.left));
                        continue;
                    }

                case IN:
                    state.returnType = ReturnType.POST;
                    result.add(state.node.val);

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

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode peek = root;
        while(!stack.isEmpty() || peek != null){
           if(peek != null) {
               stack.push(peek) ;
               peek = peek.left;
           }else{
               peek = stack.pop();
               /**
                * 弹栈时访问。
                */
               result.add(peek.val);
               peek = peek.right;
           }
        }
        return result;
    }
    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        /**
         * 先遍历左子树
         */
        inorderTraversalHelper(root.left, result);
        /**
         * 访问根节点
         */
        result.add(root.val);
        /**
         * 遍历右子树
         */
        inorderTraversalHelper(root.right, result);
    }
}
