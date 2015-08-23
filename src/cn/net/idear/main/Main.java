package cn.net.idear.main;

import cn.net.idear.two_sum.Solution;

/**
 * Created by wangdongwei on 8/23/15.
 */
public class Main {
    public static void main(String[] args){
        twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    private static  void twoSum(int[] nums , int target){
        Solution solution = new Solution();
        int[] rst = solution.twoSum(nums, target);
        for(int i = 0; i < rst.length; i++)
            System.out.print(rst[i] + " ");
        System.out.println();
    }
}
