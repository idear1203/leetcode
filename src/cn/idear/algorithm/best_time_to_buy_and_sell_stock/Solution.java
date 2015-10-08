package cn.idear.algorithm.best_time_to_buy_and_sell_stock;

/**
 * Created by wangdongwei on 9/30/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int max= 0;
        for(int i = 0; i < prices.length; i++){
            lowest = Math.min(lowest, prices[i]);
            max= Math.max(prices[i] - lowest, max);
        }
        return max;
    }
}
