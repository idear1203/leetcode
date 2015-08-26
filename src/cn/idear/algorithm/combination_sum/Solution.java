package cn.idear.algorithm.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 8/26/15.
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 */
public class Solution {
 public List<List<Integer>> combinationSum(int[] candidates, int target) {
  List<List<Integer>> rst = new ArrayList<List<Integer>>();
  Arrays.sort(candidates);
  combinationSumHelper(candidates, target, rst, 0, new ArrayList<Integer>(), 0);
  return rst;
 }

 private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> rst, int sum, List<Integer> path,
                                   int index) {
  if(sum == target) {
   if(!path.isEmpty()) {
    List<Integer> resultPath = new ArrayList<Integer>();
    resultPath.addAll(path);
    rst.add(resultPath);
   }
  }else if(sum < target){
   for(int i = index; i < candidates.length; i++){
    if(sum + candidates[i] > target)
     break;
    path.add(candidates[i]);
    combinationSumHelper(candidates, target, rst, sum + candidates[i], path, i);
    path.remove(path.size() - 1);
   }
  }
 }
}
