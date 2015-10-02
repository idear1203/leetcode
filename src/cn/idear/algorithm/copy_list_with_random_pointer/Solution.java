package cn.idear.algorithm.copy_list_with_random_pointer;

import cn.idear.algorithm.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        /**
         * 建立从原象到像的映射
         */
        for(RandomListNode cur = head; cur != null; cur = cur.next)
            map.put(cur, new RandomListNode(cur.label));
        /**
         * 对新链表的next和random域进行拷贝。
         */
        for(RandomListNode cur = head; cur != null; cur = cur.next){
            RandomListNode copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
        }
        return map.get(head);
    }
}
