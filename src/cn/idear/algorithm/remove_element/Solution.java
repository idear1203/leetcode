package cn.idear.algorithm.remove_element;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/26/15.
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i = 0; i < nums.length; i++){
           if(nums[i] != val){
               nums[len++] = nums[i];
           }
        }
        return len;
    }
// /**
//  * Accepted.328ms
//  */
//    public int removeElement(int[] nums, int val) {
//        int j = nums.length;
//        int len = 0;
//        for(int i = 0; i < j; i++){
//            if(nums[i] != val){
//                len++;
//            }else{
//                j--;
//                while(i < j && nums[j] == val) j--;
//                if(i < j) nums[len++] = nums[j];
//            }
//        }
//        return len;
//    }
}
