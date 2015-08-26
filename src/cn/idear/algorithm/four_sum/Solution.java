package cn.idear.algorithm.four_sum;

import java.util.*;

/**
 * Created by wangdongwei on 8/26/15.
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */
public class Solution {
    /**
     * two sum + two sum = four sum.
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        /**
         * map sum to [index1, index2]，然后问题就变成了two sum问题。
         */
        Map<Integer, List<TwoSum>> map = new HashMap<>();
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                TwoSum twoSum = new TwoSum(i, j);
                List<TwoSum> list = map.get(sum);
                if(list == null){
                    list = new ArrayList<>();
                    map.put(sum,list);
                }
                list.add(twoSum);
            }
        }
       for(Integer a: map.keySet()){
           int b = target - a;
           if(a <= b) {
               List<TwoSum> blist = map.get(b);
               if (blist != null) {
                   List<TwoSum> alist = map.get(a);
                   for (TwoSum tsa : alist) {
                       for (TwoSum tsb : blist) {
                           if (tsa.overlap(tsb)) continue;
                           Integer[] array = new Integer[]{nums[tsa.i], nums[tsa.j], nums[tsb.i], nums[tsb.j]};
                           Arrays.sort(array);
                           List<Integer> rstList = Arrays.asList(array);
                           if(!result.contains(rstList))
                               result.add(rstList);
                       }
                   }
               }
           }
       }
        return result;
    }
    /**
     * Accepted.
     * 排序+夹逼。
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
           for(int j = nums.length - 1; j > i + 2; j--){
               if(j > i + 2 && j < nums.length - 1 && nums[j] == nums[j + 1]) continue;
               int k = i + 1;
               int l = j - 1;
               while(k < l){
                  int sum = nums[i] + nums[j] + nums[k] + nums[l];
                   if(sum < target){
                       k++;
                       while(k < l && nums[k] == nums[k - 1]) k++;
                   }else if(sum > target){
                       l--;
                       while (k < l && nums[l] == nums[l + 1]) l--;
                   }else {
                       result.add(Arrays.asList(nums[i], nums[k], nums[l], nums[j]));
                       k++;
                       l--;
                       while(k < l && nums[k] == nums[k - 1]) k++;
                       while (k < l && nums[l] == nums[l + 1]) l--;
                   }
               }
           }
        }
        return result;
    }

    private class TwoSum {

        private final int i;

        private final int j;

        public TwoSum(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean overlap(TwoSum other){
            return i == other.i || j == other.j || i == other.j || j == other.i;
        }
    }
}
