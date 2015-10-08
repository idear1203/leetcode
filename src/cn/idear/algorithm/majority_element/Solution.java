package cn.idear.algorithm.majority_element;

import java.util.Arrays;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {

    /**
     * Runtime: O(n) — Moore voting algorithm: We maintain a current candidate and a counter initialized to 0.
     * As we iterate the array, we look at the current element x:
     If the counter is 0, we set the current candidate to x and the counter to 1.
     If the counter is not 0, we increment or decrement the counter based on whether x is the current candidate.
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate)
                counter++;
            else if(counter > 1){
                counter--;
            }else{
               candidate = nums[i];
            }
        }
        return candidate;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
