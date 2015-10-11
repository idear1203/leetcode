package cn.idear.algorithm.contains_duplicate_iii;

/**
 * Created by wangdongwei on 10/11/15.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length < 2) return false;
        int fast = 1, slow = 0;
        long diffValue;
        int diffIndices;
        while(slow < fast){
            diffValue = Math.abs((long)(nums[fast] - nums[slow]));
            diffIndices = fast - slow;
            if(diffValue <= t && diffIndices <= k)
                return true;
            if(diffIndices > k){
                slow++;
            }else{//diffValue > t
                if(fast == nums.length - 1)
                    slow++;
                else
                    fast++;
            }
        }
        return false;
    }
}
