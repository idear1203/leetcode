package cn.idear.algorithm.rotate_array;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        for(int i = 0; i < n && count < n; i++){
            int pivot = nums[i];
            int t = (i + k) % n;
            int s = t;
            do{
                int tmp = nums[s];
                nums[s] = pivot;
                pivot = tmp;
                count++;
                s = (s + k) % n;
            }while(s != t);
        }
    }
}
