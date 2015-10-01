package cn.idear.algorithm.single_number_ii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for(int i = 0; i < nums.length; i++) {
            /**
             * 此时one还没有更新，若one的某一位为1说明该位上的1出现过1次。
             * 首先更新two。如果one某一位为1，本次nums[i]的位上又出现了1，则two的对应位置1.
             */
            two |= one & nums[i];
            /**
             *  1出现两次，one对应位应该清零。
             */
            one ^= nums[i];
            /**
             * three容易理解，在one和two中都被置位的比特位，在three中置1
             */
            three = one & two;
            /**
             * 如果某一位出现三次，则将其在One和two中清零。
             */
            one &= ~three;
            two &= ~three;
        }
        /**
         * 最终，two和three的值都为0，one的值是结果。
         */
//        System.out.printf("%d %d %d\n", one, two, three);
        return one;
    }

    public int singleNumber1(int[] nums) {
        int[] count = new int[Integer.SIZE];
        Arrays.fill(count, 0);
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            for(int j = 0; j < Integer.SIZE; j++){
                if(((num >> j) & 0x01) != 0){
                    count[j] = (count[j] + 1) % 3;
                }
            }
        }
        int rst = 0;
        for(int i = 0; i < Integer.SIZE; i++)
                rst |= count[i] << i;
        return rst;
    }
}
