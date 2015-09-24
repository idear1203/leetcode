package cn.idear.algorithm.path_sum_ii;

import cn.idear.algorithm.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangdongwei on 9/25/15.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        List<Integer> trace = new LinkedList<>();
        trace.add(root.val);
        pathSumHelper(root, sum, root.val, trace, result);
        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, int cur, List<Integer> trace, List<List<Integer>> result) {
        if(root.left == null && root.right == null) {
            if(cur == sum)
                result.add(new LinkedList<>(trace));
            return;
        }
        if(root.left != null) {
            trace.add(root.left.val);
            pathSumHelper(root.left, sum, cur + root.left.val, trace, result);
            trace.remove(trace.size() - 1);
        }
        if(root.right != null) {
            trace.add(root.right.val);
            pathSumHelper(root.right, sum, cur + root.right.val, trace, result);
            trace.remove(trace.size() - 1);
        }
    }
}
