package cn.idear.algorithm.comibination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 8/28/15.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, result, new ArrayList<Integer>(), 0, 0);
        return result;
    }

    private void combinationSum2Helper(int[] candidates, int target, List<List<Integer>> result,
                                       List<Integer> path, int index, int sum) {
        if(sum == target){
            List<Integer> newPath = new ArrayList<>(path);
            result.add(newPath);
        }else if(sum < target){
            for(int i = index; i < candidates.length; i++){
                if(i > index && candidates[i] == candidates[i - 1]) continue;
                if(sum + candidates[i] <= target){
                    path.add(candidates[i]);
                    combinationSum2Helper(candidates, target, result, path, i + 1, sum + candidates[i]);
                    path.remove(path.size() - 1);
                }
                else
                    break;
            }
        }
    }
}
