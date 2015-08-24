package cn.net.idear.merge_k_sorted_lists;

import cn.net.idear.util.ListNode;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/24/15.
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Solution {

    private int safe(ListNode l){
        return l == null ? Integer.MAX_VALUE : l.val;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        ListNode l1 = mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2));
        ListNode l2 = mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length));
        return merge2Lists(l1, l2);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        for(ListNode currentNode = dummy; l1 != null || l2 != null; currentNode = currentNode.next){
           int val1 = safe(l1);
            int val2 = safe(l2);
            if(val1 < val2){
                currentNode.next = l1;
                l1 = l1.next;
            }
            else {
                currentNode.next = l2;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
