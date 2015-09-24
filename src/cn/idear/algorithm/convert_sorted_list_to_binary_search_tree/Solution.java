package cn.idear.algorithm.convert_sorted_list_to_binary_search_tree;

import cn.idear.algorithm.util.ListNode;
import cn.idear.algorithm.util.TreeNode;

/**
 * Created by wangdongwei on 9/24/15.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null){
            TreeNode root = new TreeNode(head.val);
            root.left = root.right = null;
            return root;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode midPrev = findMidPrev(dummy);
        ListNode mid = midPrev.next;
        midPrev.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMidPrev(ListNode head) {
        ListNode fast = head, slow = head;
        for(; fast.next != null && fast.next.next != null; fast = fast.next.next, slow = slow.next);
        return slow;
    }
}
