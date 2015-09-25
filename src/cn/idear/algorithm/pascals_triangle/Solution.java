package cn.idear.algorithm.pascals_triangle;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
            return new LinkedList<>();
        List<List<Integer>> result = generate(numRows - 1);
        if(numRows == 1) {
            List<Integer> level = Collections.singletonList(1);
            result.add(level);
        }else{
            List<Integer> level = new LinkedList<>();
            List<Integer> last = result.get(result.size() - 1);
            level.add(1);
            for(int i = 1 ; i < last.size(); i++){
                level.add(last.get(i) + last.get(i - 1));
            }
            level.add(1);
            result.add(level);
        }
        return result;
    }
}
