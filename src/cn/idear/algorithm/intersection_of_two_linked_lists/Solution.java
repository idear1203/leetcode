package cn.idear.algorithm.intersection_of_two_linked_lists;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 将两个链表长度统一，较长的链表头结点后移。
         */
        for(ListNode headAA = headA, headBB = headB; headAA != null || headBB != null;){
            if(headAA == null){
                headB = headB.next;
                headBB = headBB.next;
            }else if(headBB == null){
                headA = headA.next;
                headAA = headAA.next;
            }else{
                headAA = headAA.next;
                headBB = headBB.next;
            }
        }
        while(headA != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
