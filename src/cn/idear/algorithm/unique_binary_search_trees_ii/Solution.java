package cn.idear.algorithm.unique_binary_search_trees_ii;

import cn.idear.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 9/20/15.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTree = generateTreesHelper(start, i - 1);
            List<TreeNode> rightTree = generateTreesHelper(i + 1, end);
            for(TreeNode leftNode: leftTree){
                for(TreeNode rightNode: rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
