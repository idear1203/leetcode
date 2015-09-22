package cn.idear.algorithm.symmetric_tree;

import cn.idear.algorithm.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangdongwei on 9/21/15.
 */
public class Solution {
    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if(p == null && q != null)
                return false;
            if(p != null && q == null)
                return false;
            if(p != null){
                if(p.val != q.val)
                    return false;
                queue.add(p.left);
                queue.add(q.right);
                queue.add(p.right);
                queue.add(q.left);
            }
        }
        return true;
    }
    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null && right != null)
            return false;
        if(left != null && right == null)
            return false;
        return left == null || (left.val == right.val
                && isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left));
    }
}
