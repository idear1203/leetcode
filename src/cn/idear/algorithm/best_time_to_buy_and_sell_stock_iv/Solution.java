package cn.idear.algorithm.best_time_to_buy_and_sell_stock_iv;

/**
 * Created by wangdongwei on 10/11/15.
 */
public class Solution {
    //优化时间复杂度，用tmp保存历史..学习这种历史的思想。
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || n == 0) return 0;
        if (k >= n){
            int max = 0;
            for (int i = 1; i < n; i++){
                int tmp = prices[i] - prices[i - 1];
                max +=  tmp > 0 ? tmp : 0;
            }
            return max;
        }
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++){
            int tmp = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++){
                // for (int jj = 0; jj < j; jj++){
                //     tmp = Math.max(tmp, dp[i - 1][jj] - prices[jj]);
                // }
                tmp = Math.max(tmp, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmp);
            }
        }
        return dp[k][n - 1];
    }
    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfit1(int k, int[] prices) {
        if(prices.length < 2) return 0;
        /**
         * k最够多时可获得最大收益。
         */
        if(k >= prices.length){
            int max = 0;
            for(int i = 1; i < prices.length; i++)
                if(prices[i] > prices[i - 1])
                    max += prices[i] - prices[i - 1];
            return max;
        }
        int[][] dp = new int[k + 1][prices.length];
        // //if there is only one price data point you can't make any transaction.
        // for(int i = 0; i <= k; i++)
        //     dp[i][0] = 0;
        // //0 transactions makes 0 profit
        // for(int i = 0; i < prices.length; i++)
        //     dp[0][i] = 0;
        for(int i = 1; i <= k; i++){
            for(int j = 1; j < prices.length; j++){
                int max = Integer.MIN_VALUE;
                for(int jj = 0; jj < j; jj++)
                    max = Math.max(max, dp[i - 1][jj] - prices[jj]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
            }
        }
        return dp[k][prices.length - 1];
    }
}
