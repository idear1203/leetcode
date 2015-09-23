package cn.idear.algorithm.maximum_depth_of_binary_tree;

import cn.idear.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by wangdongwei on 9/24/15.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private class State{
        TreeNode treeNode;
        int curDepth;
        State(TreeNode treeNode, int curDepth){
            this.treeNode = treeNode;
            this.curDepth = curDepth;
        }
    }

    public int maxDepth1(TreeNode root) {
        if(root == null)
            return 0;
        int maxDepth = 0;
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 1));
        while(!stack.isEmpty()){
            State state = stack.pop();
            if(state.curDepth > maxDepth)
                maxDepth = state.curDepth;
            if(state.treeNode.right != null)
                stack.push(new State(state.treeNode.right, state.curDepth + 1));
            if(state.treeNode.left != null)
                stack.push(new State(state.treeNode.left, state.curDepth + 1));
        }
        return maxDepth;
    }
}
