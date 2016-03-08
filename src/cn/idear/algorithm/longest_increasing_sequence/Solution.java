package cn.idear.algorithm.longest_increasing_sequence;

import java.util.Arrays;

/**
 * Created by wangdongwei on 3/5/16.
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        int max = 1;
        dp[max] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > dp[max]){
                dp[++max] = nums[i];
            } else{
                dp[binarySearch(dp, 1, max, nums[i]) + 1] = nums[i];
            }
        }
        return max;
    }

    private int binarySearch(int[] dp, int start, int end, int key){
        while (start <= end){
            int mid = (start + end)>>1;
            if (dp[mid] < key && key <= dp[mid + 1])
                return mid;
            else if (dp[mid] < key)
                start = start + 1;
            else
                end = end - 1;
        }
        return 0;
    }

    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = nums.length - 2; i >= 0; i--){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] > nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}