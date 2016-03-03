package cn.idear.algorithm.lowest_common_ancestor_of_a_binary_search_tree;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        if(root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(p.val > q.val) return lowestCommonAncestor(root, q, p);
//        if(p.val == root.val || q.val == root.val) return root;
//        if(p.val < root.val && q.val > root.val)
//            return root;
//        else if(q.val < root.val)
//            return lowestCommonAncestor(root.left, p, q);
//        else
//            return lowestCommonAncestor(root.right, p, q);
//    }
}
