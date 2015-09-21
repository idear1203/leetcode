package cn.idear.algorithm.recover_binary_search_tree;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/21/15.
 */
public class Solution {

    TreeNode pre, next, last;
    int count = 0;

    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(pre, next);
    }

    private void swap(TreeNode pre, TreeNode next) {
        int tmp = pre.val;
        pre.val = next.val;
        next.val = tmp;
    }

    private void inorder(TreeNode root) {
       if(root == null)
           return;
        /**
         * 最多只能发现两个非递增序列。
         */
        if(count == 2)
            return;
        /**
         * 遍历左子树
         */
        inorder(root.left);
        /**
         * 访问根节点
         */
        if(last != null && last.val > root.val){
            count++;
            pre = root;
            if(next == null)
                next = last;
        }
        last = root;
        /**
         * 遍历右子树
         */
        inorder(root.right);
    }
}
