package cn.net.idear.merge_two_sorted_lists;

import cn.net.idear.util.ListNode;

/**
 * Created by wangdongwei on 8/24/15.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        for(ListNode node = dummy; l1 != null || l2 != null; node = node.next){
            int val1 = (l1 == null ? Integer.MAX_VALUE: l1.val);
            int val2 = (l2 == null ? Integer.MAX_VALUE: l2.val);
            if(val1 < val2){
               node.next = l1;
               l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
