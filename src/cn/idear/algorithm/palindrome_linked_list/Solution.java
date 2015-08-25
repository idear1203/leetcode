package cn.idear.algorithm.palindrome_linked_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/25/15.
 * Given a singly linked list, determine if it is a palindrome.
 */
public class Solution {
    public ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if(head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode mid = findMidNode(head);
        ListNode halfHead = reverseList(mid);
        while(head != null && halfHead != null){
            if(head.val != halfHead.val)
                return false;
            head = head.next;
            halfHead = halfHead.next;
        }
        return true;
    }
}
