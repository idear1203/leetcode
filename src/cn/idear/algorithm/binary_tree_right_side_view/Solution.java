package cn.idear.algorithm.binary_tree_right_side_view;

import cn.idear.algorithm.util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangdongwei on 10/7/15.
 */
public class Solution {
    /**
     * DFS
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        List<Integer> result = new LinkedList<>();
        result.add(root.val);
        result.addAll(right);
        /**
         * 学习subList
         */
        if(left.size() > right.size())
            result.addAll(left.subList(right.size(), left.size()));
        return result;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = len - 1; i >= 0; i--){
                TreeNode node = queue.poll();
                if(i == len - 1)
                    result.add(node.val);
                if(node.right != null)
                    queue.add(node.right);
                if(node.left != null)
                    queue.add(node.left);
            }
        }
        return result;
    }
}
