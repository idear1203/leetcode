package cn.idear.algorithm.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by wangdongwei on 9/30/15.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        int max = 0;
        /**
         * 注意此处迭代必须是nums不能是set，否则会产生ConcurrentModificationException
         */
        for(int num : nums){
            /**
             * 学习remove的返回值，如果元素存在，成功去掉，返回true，否则返回false
             */
            if(set.remove(num)) {
                int len = 1;
                for (int n = num + 1; set.contains(n); n++) {
                    len++;
                    set.remove(n);
                }
                for (int n = num - 1; set.contains(n); n--) {
                    len++;
                    set.remove(n);
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
