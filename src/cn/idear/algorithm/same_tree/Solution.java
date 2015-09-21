package cn.idear.algorithm.same_tree;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/21/15.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null)
            return false;
        if(p != null && q == null)
            return false;
        return p == null || (p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }
}
