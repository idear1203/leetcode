package cn.idear.algorithm.ugly_number_ii;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangdongwei on 2/28/16.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>(n, Collections.reverseOrder());
        Queue<Long> q2 = new LinkedList<>();
        Queue<Long> q3 = new LinkedList<>();
        Queue<Long> q5 = new LinkedList<>();
        queue.offer((long)1);
        q2.offer((long)2);
        q3.offer((long)3);
        q5.offer((long)5);
        while (queue.size() < n){
            long head2 = q2.peek();
            long head3 = q3.peek();
            long head5 = q5.peek();
            long min = Math.min(head2, Math.min(head3, head5));
            queue.offer(min);
            q5.offer(min * 5);
            if (min == head5) {
                q5.poll();
            } else {
                q3.offer(min * 3);
                if(min == head3){
                    q3.poll();
                } else if(min == head2){
                    q2.poll();
                    q2.offer(min * 2);
                }
            }
        }
        long first = queue.poll();
        return (int)first;
    }
}
