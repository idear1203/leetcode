package cn.idear.algorithm.candy;

import java.util.Arrays;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        /**
         * 每个孩子至少一块糖。
         */
        Arrays.fill(candies, 1);
        /**
         * 学习把问题分解的思路。neighbor = left + right.
         */
        /**
         * 自左向右保证得分高的比左侧的小朋友的分的糖多。
         */
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1])
                candies[i] = candies[i - 1] + 1;
        /**
         * 自右向左保证得分高的比右侧的小朋友的分的糖多。
         */
        for(int i = ratings.length - 2; i >= 0; i--)
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        /**
         * 计算总糖数。
         */
        int total = 0;
        for(int i = 0; i < candies.length; i++)
            total += candies[i];
        return total;
    }
}
