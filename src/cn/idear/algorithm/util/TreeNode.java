package cn.idear.algorithm.util;

/**
 * Created by wangdongwei on 9/9/15.
 */
public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public static TreeNode createTree(int[] nums, int replacement){
        if(nums.length == 0)
            return null;
        TreeNode[] nodes = new TreeNode[nums.length];
        for(int i = 0; i < nums.length; i++)
            nodes[i] = nums[i] == replacement ? null : new TreeNode(nums[i]);
        int pos = 1;
        for(int i = 0; i < nums.length; i++) {
            if (nodes[i] != null) {
                nodes[i].left = pos < nums.length ? nodes[pos++] : null;
                nodes[i].right = pos < nums.length ? nodes[pos++] : null;
            }
        }
        return nodes[0];
    }

    public static TreeNode createTree(int[] nums){
        return createTree(nums, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        if (val != treeNode.val) return false;
        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
        return !(right != null ? !right.equals(treeNode.right) : treeNode.right != null);

    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
