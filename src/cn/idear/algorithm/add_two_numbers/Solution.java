package cn.idear.algorithm.add_two_numbers;

/**
 * Created by wangdongwei on 8/23/15.
 */

import cn.idear.algorithm.util.ListNode;

/**
 You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 大数加法，注意进位和两个大数位数不一致。
 */
public class Solution {
 /**
  * Definition for singly-linked list.
  * public class ListNode {
  *     int val;
  *     ListNode next;
  *     ListNode(int x) { val = x; }
  * }
  */
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  ListNode dummy = new ListNode(-1);
  ListNode pred = dummy;
  int carry = 0;
  for(ListNode n1 = l1, n2 = l2; n1 != null || n2 != null;
       pred = pred.next){
   int n1val = (n1 == null ? 0 : n1.val);
   int n2val = (n2 == null ? 0 : n2.val);
   int rst = n1val + n2val + carry;
   int val = rst % 10;
   pred.next = new ListNode(val);
   carry = rst / 10;
   if(n1 != null)
    n1 = n1.next;
   if(n2 != null)
    n2 = n2.next;
  }
  if(carry > 0)
   pred.next = new ListNode(carry);
  return dummy.next;
 }
}
