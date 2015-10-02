package cn.idear.algorithm.util;

/**
 * Created by wangdongwei on 8/23/15.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int x) { label = x; }

    /**
     * this method is not correct for random list node
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RandomListNode listNode = (RandomListNode) o;

        if (label != listNode.label) return false;
        return !(next != null ? !next.equals(listNode.next) : listNode.next != null);

    }

    @Override
    public int hashCode() {
        int result = label;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    public static RandomListNode make(int[] nums){
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode curNode = dummy;
        for(int i = 0; i < nums.length; i++){
            RandomListNode newNode = new RandomListNode(nums[i]);
            curNode.next = newNode;
            curNode = curNode.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}
