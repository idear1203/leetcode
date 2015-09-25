package cn.idear.algorithm.util;

/**
 * Created by wangdongwei on 9/25/15.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    public TreeLinkNode(int x) { val = x; }

    public static TreeLinkNode make(int[] nums){
        return make(nums, -1);
    }

    private static TreeLinkNode make(int[] nums, int target) {
        if(nums.length == 0)
            return null;
        TreeLinkNode[] nodes = new TreeLinkNode[nums.length];
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != target)
                nodes[i].val = nums[i];
            else
                nodes[i] = null;
        int s = 1;
        for(int i = 0; i < nums.length; i++){
            if(nodes[i] != null){
                nodes[i].left = s < nums.length ? nodes[s++] : null;
                nodes[i].right = s < nums.length ? nodes[s++] : null;
            }
        }
        return nodes[0];
    }

}
