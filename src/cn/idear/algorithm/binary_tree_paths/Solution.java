package cn.idear.algorithm.binary_tree_paths;

import cn.idear.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idear on 15-11-2.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right == null)
            result.add(String.valueOf(root.val));
        else{
            if(root.left != null){
                for(String s : binaryTreePaths(root.left))
                    result.add(root.val + "->" + s);
            }
            if(root.right != null){
                for(String s: binaryTreePaths(root.right))
                    result.add(root.val + "->" + s);
            }
        }
        return result;
    }
}
