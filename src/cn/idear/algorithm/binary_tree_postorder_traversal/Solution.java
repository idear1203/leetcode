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
    public List<Integer> postorderTraversal(TreeNode root) {
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
}
