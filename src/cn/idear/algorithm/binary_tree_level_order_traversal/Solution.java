package cn.idear.algorithm.binary_tree_level_order_traversal;

import cn.idear.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangdongwei on 9/22/15.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> nums = new ArrayList<>();
           for(int i = 0; i < len; i++) {
               TreeNode node = queue.poll();
               nums.add(node.val);
               if(node.left != null)
                   queue.add(node.left);
               if(node.right != null)
                   queue.add(node.right);
           }
            result.add(nums);
        }
        return result;
    }
}
