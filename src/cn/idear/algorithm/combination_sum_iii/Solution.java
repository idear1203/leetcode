package cn.idear.algorithm.combination_sum_iii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 10/12/15.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k == 0 || n == 0) return result;
        Integer[] stack = new Integer[k];
        combinationSum3Helper(0, k, n, result, stack, 1, 0);
        return result;
    }
    private void combinationSum3Helper(int p, int k, int n, List<List<Integer>> result, Integer[] stack, int num, int sum){
        if(n == sum){
            if(k == p)
                result.add(new ArrayList<>(Arrays.asList(stack)));
        }else if(n > sum){
            if(k > p){
                /**
                 * 注意这种剪枝的方法
                 */
                if(sum + 9 * (k - p) < n)
                    return;
                if(sum + (k - p) > n)
                    return;
                for(int i = num; i <= 9; i++){
                    stack[p] = i;
                    combinationSum3Helper(p + 1, k, n, result, stack, i + 1, sum + i);
                }
            }
        }
    }
}
