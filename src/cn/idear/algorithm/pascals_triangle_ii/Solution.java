package cn.idear.algorithm.pascals_triangle_ii;

import java.util.*;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {

    /**
     * 动态规划
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] nums = new Integer[rowIndex + 1];
        Arrays.fill(nums, 1);
        for(int i = 1; i < rowIndex; i++){
            /**
             * 细节。注意j的旗帜位置的确定。以及为何倒序。
             */
            for(int j = i; j >= 1; j--){
                nums[j] = nums[j] + nums[j - 1];
            }
        }
        return Arrays.asList(nums);
    }

    /**
     * 数学方法
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow1(int rowIndex){
        Integer[] rst = new Integer[rowIndex + 1];
        boolean isEven = (rowIndex & 0x01) == 0;
        int times = rowIndex / 2 + 1;
        rst[0] = 1;
        for(int i = 1; i < times; i++)
            rst[i] = (int)(((long)rst[i - 1]) * (rowIndex + 1 - i) / i);
        int half = times;
        if(isEven) times--;
        for(int i = 0; i < times; i++)
            rst[half + i] = rst[times - 1 - i];
        return Arrays.asList(rst);
    }

    /**
     * 递归
     * @param rowIndex
     * @return
     */
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> result = new ArrayList<>(rowIndex);
//        Collections.fill(result, 1);
//        for(int i = 1; i < rowIndex - 1; i++)
//            for(int j = i + 1; )
//    }

//    public List<Integer> getRow(int rowIndex) {
//        if(rowIndex == 0)
//            return new LinkedList<Integer>(){{add(1);}};
//        LinkedList<Integer> result = (LinkedList<Integer>) getRow(rowIndex - 1);
//        int len = result.size();
//        for(int i = 0; i < len - 1; i++){
//            int cur = result.poll();
//            result.add(cur + result.peek());
//        }
//        result.add(1);
//        return result;
//    }
}
