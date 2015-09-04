package cn.idear.algorithm.partition_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 9/4/15.
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 You should preserve the original relative order of the nodes in each of the two partitions.
 For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class Solution {
    public ListNode partition(ListNode head, int x){
        if(head == null || head.next == null)
            return head;
        ListNode formerDummy = new ListNode(-1);
        ListNode laterDummy = new ListNode(-1);
        ListNode formerTail = formerDummy;
        ListNode laterTail = laterDummy;
        for(ListNode curNode = head; curNode != null; curNode = curNode.next){
            if(curNode.val < x){
                formerTail.next = curNode;
                formerTail = formerTail.next;
            }else{
                laterTail.next = curNode;
                laterTail = laterTail.next;
            }
        }
        formerTail.next = laterDummy.next;
        laterTail.next = null;
        return formerDummy.next;
    }
}
