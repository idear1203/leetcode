package cn.idear.algorithm.best_time_to_buy_and_sell_stock_iii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 9/30/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;

        int[] leftMax = new int[prices.length];
        int[] rightMax = new int[prices.length];

        /**
         * 计算从0...i的最大值
         */
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            leftMax[i] = Math.max(leftMax[i - 1], prices[i] - min);
        }

        /**
         * 计算从i...end的最大值
         */
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            rightMax[i] = Math.max(rightMax[i + 1], max - prices[i]);
        }

        /**
         * 计算和的最大值
         */
        max = 0;
        for(int i = 0; i < prices.length; i++)
           max = Math.max(max, leftMax[i] + rightMax[i]);

        return max;
    }
}
