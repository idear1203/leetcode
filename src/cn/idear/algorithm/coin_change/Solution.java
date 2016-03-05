package cn.idear.algorithm.coin_change;

import java.util.Arrays;

/**
 * Created by wangdongwei on 3/3/16.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] rst = new int[amount + 1];
        Arrays.fill(rst, Integer.MAX_VALUE);
        for (int coin : coins){
            if (coin <= amount)
                rst[coin] = 1;
        }
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0 && rst[i - coins[j]] != Integer.MAX_VALUE){
                    rst[i] = Math.min(rst[i], rst[i - coins[j]] + 1);
                }
            }
        }
        return rst[amount] == Integer.MAX_VALUE ? -1 : rst[amount];
    }
}
