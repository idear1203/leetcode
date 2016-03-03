package cn.idear.algorithm.count_complete_tree_nodes;

import cn.idear.algorithm.util.TreeNode;

/**
 * Created by idear on 15-11-2.
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);
        if(leftHeight == rightHeight)
            return (1 << leftHeight) - 1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getHeight(TreeNode root, boolean isLeft) {
        int height = 0;
        for(TreeNode node = root; node != null; node = isLeft ? node.left : node.right)
            height++;
        return height;
    }
}
