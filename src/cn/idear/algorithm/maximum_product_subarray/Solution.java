package cn.idear.algorithm.maximum_product_subarray;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];

        int positiveHistory = 1;
        int negativeHistory = 1;

        for(int i = 0; i < nums.length; i++){
            positiveHistory *= nums[i];
            negativeHistory *= nums[i];
            /**
             * 永远不要让负能量超过正能量。
             */
            if(negativeHistory > positiveHistory){
                int tmp = negativeHistory;
                negativeHistory = positiveHistory;
                positiveHistory = tmp;
            }
            /**
             * 过去与现在的较量。如果过去的点滴积累比不过当下的瞬间，那么忘记过去，拥抱现在。
             */
            positiveHistory = Math.max(positiveHistory, nums[i]);
            negativeHistory = Math.min(negativeHistory, nums[i]);
            /**
             * 最大化正能量。
             */
            max = Math.max(positiveHistory, max);
        }
        return max;
    }
}