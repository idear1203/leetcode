package cn.idear.algorithm.binary_tree_inorder_traversal;

import cn.idear.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdongwei on 9/9/15.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
