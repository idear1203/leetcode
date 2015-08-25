package cn.idear.algorithm.util;

/**
 * Created by wangdongwei on 8/23/15.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) return false;
        return !(next != null ? !next.equals(listNode.next) : listNode.next != null);

    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    public static ListNode createListByVal(int[] nums){
        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        for(int i = 0; i < nums.length; i++){
            ListNode newNode = new ListNode(nums[i]);
            curNode.next = newNode;
            curNode = curNode.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
