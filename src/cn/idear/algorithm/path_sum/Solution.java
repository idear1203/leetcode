package cn.idear.algorithm.path_sum;

import cn.idear.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by wangdongwei on 9/25/15.
 */
public class Solution {
    private class State{
        TreeNode node;
        int sum;
        State(TreeNode node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }

    /**
     * 分析：可采用先序遍历模型。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, root.val));
        while(!stack.isEmpty()){
           State state = stack.pop();
            TreeNode node = state.node;
            int cur = state.sum;
            if(cur == sum && node.left == null && node.right == null)
                return true;
            if(node.left != null)
                stack.push(new State(node.left, cur + node.left.val));
            if(node.right != null)
                stack.push(new State(node.right, cur + node.right.val));
        }
        return false;
    }
}
