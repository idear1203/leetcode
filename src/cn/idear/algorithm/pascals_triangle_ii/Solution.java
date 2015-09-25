package cn.idear.algorithm.pascals_triangle_ii;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0)
            return new LinkedList<Integer>(){{add(1);}};
        LinkedList<Integer> result = (LinkedList<Integer>) getRow(rowIndex - 1);
        int len = result.size();
        for(int i = 0; i < len - 1; i++){
            int cur = result.poll();
            result.add(cur + result.peek());
        }
        result.add(1);
        return result;
    }
}
