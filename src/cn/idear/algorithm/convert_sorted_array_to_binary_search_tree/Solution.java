package cn.idear.algorithm.convert_sorted_array_to_binary_search_tree;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/24/15.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if(start >= end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, start, mid);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        return root;
    }
}
