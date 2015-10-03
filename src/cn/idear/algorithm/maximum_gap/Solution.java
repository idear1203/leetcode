package cn.idear.algorithm.maximum_gap;

import java.util.Arrays;

/**
 * Created by wangdongwei on 10/3/15.
 */
public class Solution {
    /**
     * 通过此题学习基数排序和桶排序这两种线性时间的排序方法
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        /**
         * d是slot的个数，因为数字是0..9，因此共有10个坑。
         */
        int d = 10;

        /**
         * 保存排序结果。
         */
        int[] aux = new int[nums.length];

        /**
         * 求数组中最大元素。
         */
        int max = nums[0];
        for(int i = 1; i < nums.length; i++)
            max = Math.max(max, nums[i]);

        int radix = 1;
        /**
         * 排序的终止条件是MSB比较完毕，如果max是32位长度，radix将溢出为负。仍然可以使算法终止。
         */
        while(max / radix > 0){
            /**
             * 记录待排序序列比较位的数字出现的次数
             */
            int[] count = new int[d];
            /**
             * 根据比较位入坑
             */
            for(int i = 0; i < nums.length; i++)
                count[(nums[i] / radix) % 10]++;
            /**
             * 根据count数组分配排好序后的aux数组的存放起始位置，count[d - 1]为元素个数。
             */
            for(int i = 1; i < d; i++)
                count[i] += count[i - 1];
            /**
             * 根据count数组排序。注意逆序，因为后面的数较大，排序完还应放在后面坑。
             */
            for(int i = nums.length - 1; i >= 0; i--)
//            for(int i = 0; i < nums.length; i++)
                aux[--count[(nums[i] / radix) % 10]] = nums[i];
            /**
             * 将aux内容拷贝回原数组
             */
            for(int i = 0; i < nums.length; i++)
                nums[i] = aux[i];
            /**
             * 更新radix
             */
            radix *= 10;
        }

        int result = nums[1] - nums[0];
        for(int i = 2; i < nums.length; i++)
            result = Math.max(result, nums[i] - nums[i - 1]);
        return result;
    }
}
