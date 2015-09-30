package cn.idear.algorithm.best_time_to_buy_and_sell_stock_ii;

/**
 * Created by wangdongwei on 9/30/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] > prices[i]){
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
