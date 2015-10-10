package cn.idear.algorithm.contains_duplicate_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdongwei on 10/11/15.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length < 2 || k == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer j = map.get(nums[i]);
            if(j != null && i - j <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
