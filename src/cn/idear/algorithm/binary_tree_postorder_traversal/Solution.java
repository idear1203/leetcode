package cn.idear.algorithm.binary_tree_postorder_traversal;

import cn.idear.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdongwei on 9/11/15.
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 */
public class Solution {
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current, last;
        current = root;
        do{
            /**
             * 先往左下走
             */
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            last = null;
            while(!stack.isEmpty()){
               current = stack.pop();
                /**
                 * 右子树为空或者已经被访问过，则访问根节点。
                 */
                if(current.right == null || current.right == last){
                    result.add(current.val);
                    last = current;
                }else{
                    /**
                     * 否则，将根节点入栈。
                     * 优先访问右子树。
                     */
                    stack.push(current);
                    current = current.right;
                    /**
                     * break是一个轮回。
                     */
                    break;
                }
            }
        }while(!stack.isEmpty());
        return result;
    }

    private enum ReturnType{
        PRE, IN, POST, DONE
    }

    private class State{

        TreeNode node;

        ReturnType type = ReturnType.PRE;

        public State(TreeNode node) {
            this.node = node;
        }

        public State(TreeNode node, ReturnType type) {
            this.node = node;
            this.type = type;
        }
    }

    /**
     * visit(left)
     * visit(right)
     * visit(root)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        if(root != null)
            stack.push(new State(root));
        while(!stack.isEmpty()){
            State state = stack.pop();
            switch (state.type){
                case PRE:
                    state.type = ReturnType.POST;
                    if(state.node.left != null){
                        stack.push(state);
                        stack.push(new State(state.node.left));
                        continue;
                    }

                case POST:
                    state.type = ReturnType.IN;
                    if(state.node.right != null){
                        stack.push(state);
                        stack.push(new State(state.node.right));
                        continue;
                    }

                case IN:
                    state.type = ReturnType.DONE;
                    result.add(state.node.val);

                default:
                    break;
            }
        }
        return result;
    }
}
