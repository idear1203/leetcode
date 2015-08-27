package cn.idear.algorithm.permutation_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 8/27/15.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return result;
        int[] prev = Arrays.copyOfRange(nums, 0, nums.length);
        do{
            computePrePermutation(prev);
            result.add(convertArrayToList(prev));
        }while (!Arrays.equals(prev, nums));
        System.out.println(result);
        return result;
    }

    private void computePrePermutation(int[] prev) {
        /**
         * 1. 从右向左找到第一个升序的位置。
         */
        int index = computeFirstIncreaseNumber(prev);
        if(index != -1){
            /**
             * 2. 从右向左找到第一个比index小的。
             */
            int smaller = computeFirstSmaller(prev, index);
            /**
             * 3. 交换index和smaller位置上的元素。
             */
            swap(prev, index, smaller);
        }
        /**
         * 将index右侧元素重排。
         */
        reverse(prev, index + 1);
    }

    private void reverse(int[] prev, int start) {
        int times = (prev.length - start) / 2;
        for(int i = 0; i < times; i++){
            swap(prev, start + i, prev.length - 1 - i);
        }
    }

    private void swap(int[] prev, int index, int smaller) {
        int tmp = prev[index];
        prev[index] = prev[smaller];
        prev[smaller] = tmp;
    }

    private int computeFirstSmaller(int[] prev, int index) {
        for(int i = prev.length - 1; i > index; i--){
            if(prev[i] < prev[index])
                return i;
        }
        return 0;
    }

    private int computeFirstIncreaseNumber(int[] prev) {
        for(int i = prev.length - 2; i >= 0; i--){
           if(prev[i] > prev[i + 1])
               return i;
        }
        return -1;
    }

    private List<Integer> convertArrayToList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            list.add(nums[i]);
        return list;
    }
}
