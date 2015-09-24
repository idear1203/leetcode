package cn.idear.algorithm.balanced_binary_tree;

import cn.idear.algorithm.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by wangdongwei on 9/24/15.
 */
public class Solution {


    private enum RetState{
       PRE, IN, POST, DONE
    }

    private class State{
        TreeNode node;
        RetState retState = RetState.IN;
        State parentState;
        int leftHeight;
        int rightHeight;

        public State(TreeNode node, State parentState) {
            this.node = node;
            this.parentState = parentState;
        }
    }


    /**
     * 利用后序遍历的方法，先分别计算左右子树的高度，然后根据平衡树的定义，
     * 比较高度差。并保存结果。
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root){
       if(root == null)
           return true;
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, null));
        while(!stack.isEmpty()){
            State state = stack.pop();
            switch (state.retState){
                case IN:
                    state.retState = RetState.POST;
                    if(state.node.left != null){
                        stack.push(state);
                        stack.push(new State(state.node.left, state));
                        continue;
                    }

                case POST:
                    state.retState = RetState.PRE;
                    if(state.node.right != null){
                        stack.push(state);
                        stack.push(new State(state.node.right, state));
                        continue;
                    }

                case PRE:
                    state.retState = RetState.DONE;
                    if(Math.abs(state.leftHeight - state.rightHeight) > 1)
                        return false;
                    else if(state.parentState != null){
                        int height = Math.max(state.leftHeight, state.rightHeight) + 1;
                        if(state.parentState.leftHeight == 0)
                            state.parentState.leftHeight = height;
                        else
                            state.parentState.rightHeight = height;
                    }
            }
        }
        return true;
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) >= 0;
    }

    private int isBalancedHelper(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = isBalancedHelper(root.left);
        int rightHeight = isBalancedHelper(root.right);
        if(leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
//    /**
//     * @param root
//     * @return
//     */
//    public boolean isBalanced(TreeNode root) {
//        if(root == null)
//            return true;
//        return  Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
//                isBalanced(root.left) && isBalanced(root.right) ;
////        /**
////         * stack overflow
////         */
////        return isBalanced(root.left) && isBalanced(root.right)
////                && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
//    }
//
//    private int getHeight(TreeNode root){
//        if(root == null)
//            return 0;
//        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//    }
}
