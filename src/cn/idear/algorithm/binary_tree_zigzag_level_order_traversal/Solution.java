package cn.idear.algorithm.binary_tree_zigzag_level_order_traversal;

import cn.idear.algorithm.util.TreeNode;

import java.util.*;

/**
 * Created by wangdongwei on 9/23/15.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> rst = new ArrayList<>();
           for(int i = 0; i < len; i++) {
              TreeNode treeNode = queue.poll();
               rst.add(treeNode.val);
               if(treeNode.left != null)
                   queue.add(treeNode.left);
               if(treeNode.right != null)
                   queue.add(treeNode.right);
           }
            if(!leftToRight)
                Collections.reverse(rst);
            leftToRight = !leftToRight;
            result.add(rst);
        }
        return result;
    }
}
