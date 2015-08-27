package cn.idear.algorithm.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangdongwei on 8/27/15.
 * Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Solution {

    /**
     * 效率不行 332ms
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(result, nums);
        return result;
    }

    private void permuteHelper(List<List<Integer>> result, int[] nums){
        if(nums.length == 1){
            result.add(new ArrayList<Integer>(Collections.singletonList(nums[0])));
        }else if(nums.length > 1){
            for(int i = 0; i < nums.length; i++){
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                for(List<Integer> list : permute(resetOf(nums, i))) {
                    list.add(nums[i]);
                    result.add(list);
                }
            }
        }
    }

    private int[] resetOf(int[] nums, int index) {
        int[] rt = new int[nums.length - 1];
        int s = 0;
        for(int i = 0; i < nums.length; i++)
            if(i != index)
                rt[s++] = nums[i];
        return rt;
    }

    /**
     * 计算next permutation. 288ms
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return result;
        else{
            int[] next = nums;
            do {
                next = computeNextPermutation(next);
                result.add(convertArrayToList(next));
            }while (!Arrays.equals(next, nums));
        }
        //System.out.println(result);
        return result;
    }

    private int[] computeNextPermutation(int[] nums) {
        int[] result = Arrays.copyOfRange(nums, 0, nums.length);
        /**
         * 1. 从右向左找到第一个降序的数字。
         */
        int index = findFirstDecreasedNumber(result);
        if(index != -1){
            /**
             * 2. 从右向左找到第一个比这个数字大的。
             */
            int bigger = findFirstLargerNumber(result, index);
            /**
             * 3. 交换index和bigger所指向的数字。
             */
            swap(result, index, bigger);
        }
        /**
         * index右侧逆序。
         */
        reverse(result, index + 1);
        return result;
    }

    private void reverse(int[] result, int start) {
        int times = (result.length - start) / 2;
        for(int i = 0; i < times; i++)
            swap(result, start + i, result.length - 1 - i);
    }

    private int findFirstLargerNumber(int[] nums, int index) {
        int pivot = nums[index];
        for(int i = nums.length - 1; i > index; i--)
            if(nums[i] > pivot)
                return i;
        return 0;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    private int findFirstDecreasedNumber(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--)
            if(nums[i] < nums[i + 1])
                return i;
        return -1;
    }

    private List<Integer> convertArrayToList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            list.add(nums[i]);
        return list;
    }
}
