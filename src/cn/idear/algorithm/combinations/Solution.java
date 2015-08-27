package cn.idear.algorithm.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 8/27/15.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combineHelper(n, k, 0, 0, result, new ArrayList<Integer>());
        //System.out.println(result);
        return result;
    }

    private void combineHelper(int n, int k, int i, int l,
                               List<List<Integer>> result, ArrayList<Integer> path) {
        if(i == k){
            result.add(new ArrayList<Integer>(path));
        }else{
           for(int j = l + 1; j <= n; j++){
              if(!path.contains(j)) {
                  path.add(j);
                  combineHelper(n, k, i + 1, j, result, path);
                  path.remove(i);
              }
           }
        }
    }
}
