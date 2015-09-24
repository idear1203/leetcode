package cn.idear.algorithm.minimum_depth_of_binary_tree;

import cn.idear.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by wangdongwei on 9/25/15.
 */
public class Solution {

    private class State{
        TreeNode node;
        int depth;

        public State(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, 1));
        int min = Integer.MAX_VALUE;
        while(!stack.isEmpty()){
            State state = stack.pop();
            TreeNode node = state.node;
            int cur = state.depth;
            if(node.left == null && node.right == null)
                min = Math.min(cur, min);
            if(node.left != null && cur < min)
                stack.push(new State(node.left, cur + 1));
            if(node.right != null && cur < min)
                stack.push(new State(node.right, cur + 1));
        }
        return min;
    }

    /**
     * 递归 2
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        return minDepthHelper(root, false);
    }

    private int minDepthHelper(TreeNode root, boolean hasBrother) {
        if(root == null)
            return hasBrother ? Integer.MAX_VALUE : 0;
        return Math.min(minDepthHelper(root.left, root.right != null), minDepthHelper(root.right, root.left != null))
                + 1;
    }

    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
