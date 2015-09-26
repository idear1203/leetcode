package cn.idear.algorithm.reorder_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null || head.next.next == null)
                return;
            ListNode mid = findMid(head);
            ListNode rHead = reverse(mid);
            ListNode dummy = new ListNode(0);
            for(ListNode l = head, r = rHead, tail = dummy; l != null;){
                tail.next = l;
                l = l.next;
                tail.next.next = r;
                tail = r;
                if(r != null) r = r.next;
            }
        }

        ListNode findMid(ListNode head){
            ListNode slow = head, fast = head;
            for(; fast.next != null && fast.next.next != null; fast = fast.next.next, slow = slow.next);
            fast = slow.next;
            slow.next = null;
            return fast;
        }

        ListNode reverse(ListNode head){
            ListNode dummy = new ListNode(0);
            while(head != null){
                ListNode next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = next;
            }
            return dummy.next;
        }
}
