package cn.idear.algorithm.remove_duplicates_from_sorted_list_ii;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head != null && head.next != null){
            ListNode node;
            boolean shouldDelete = false;
            for(node = head; node.next != null && node.next.val == head.val; node = node.next){
                if(!shouldDelete)
                    shouldDelete = true;
            }
            if(shouldDelete)
                head = deleteDuplicates(node.next);
            else
                head.next = deleteDuplicates(node.next);
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode tail = dummy;
        for(ListNode curNode = head.next; curNode != null;){
            if(curNode.val == head.val){
               while(curNode != null && curNode.val == head.val)
                   curNode = curNode.next;
                head = curNode;
                if(curNode != null)
                    curNode = curNode.next;
            }else{
                tail.next = head;
                tail = tail.next;
                curNode = curNode.next;
                head = head.next;
            }
        }
        if(head != null)
            head.next = null;
        tail.next = head;
        return dummy.next;
    }
}
