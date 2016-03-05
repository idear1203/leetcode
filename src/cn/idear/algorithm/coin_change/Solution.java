package cn.idear.algorithm.coin_change;

import java.util.Arrays;

/**
 * Created by idear on 16-3-5.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin : coins){
            if (coin <= amount)
                dp[coin] = 1;
        }
        for (int i = 1; i <= amount; i++){
            if (dp[i] == Integer.MAX_VALUE){
                for (int j = 0; j < coins.length; j++){
                    if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
