package cn.idear.algorithm.binary_tree_level_order_traversal_ii;

import cn.idear.algorithm.util.TreeNode;

import java.util.*;

/**
 * Created by wangdongwei on 9/24/15.
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int len = queue.size();
                List<Integer> rst = new LinkedList<>();
                for(int i = 0; i < len; i++){
                   TreeNode node = queue.poll();
                   rst.add(node.val);
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                }
                /**
                 * 学习linkedlist push用法
                 */
                result.push(rst);
            }
        }
        return result;
    }
}
