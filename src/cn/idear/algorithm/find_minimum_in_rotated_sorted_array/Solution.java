package cn.idear.algorithm.find_minimum_in_rotated_sorted_array;

/**
 * Created by wangdongwei on 8/28/15.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class Solution {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    private int findMinHelper(int[] nums, int start, int end) {
        if(start == end){
            return nums[start];
        }else{
            int midpos = (start + end) >> 1;
            int s = nums[start];
            int e = nums[end];
            int m = nums[midpos];
            if(s <= m && m <= e) {
                /**
                 * 没有旋转的情形。
                 */
                return s;
            }else if(s <= m && m >= e){
                /**
                 * 最小值一定在后半段
                 * 2 3 4 5 1
                 */
                /**
                 * midpos + 1把midpos位置上的元素排除掉了。这是安全的。
                 */
                return findMinHelper(nums, midpos + 1, end);
            }else //if(s >=m && m <= e)
            {
                return findMinHelper(nums, start, midpos);
            }
        }
    }

//    /**
//     * Accepted.
//     * @param nums
//     * @param start
//     * @param end
//     * @return
//     */
//    private int findMinHelper(int[] nums, int start, int end) {
//        int midpos = (start + end) >> 1;
//        int s = nums[start];
//        int e = nums[end];
//        int m = nums[midpos];
//        if(m <= nums[(midpos - 1 + nums.length) % nums.length])
//            return m;
////            if(s <= m && m <= e){
////                /**
////                 * 说明没有旋转。
////                 */
////                return findMinHelper(nums, start, midpos - 1);
////            }else
//        if(s <= m && m >= e){
//            /**
//             * 说明在后半段。
//             */
//            return findMinHelper(nums, midpos + 1, end);
//        }else{ //if(s >= m && m <= e){
//            /**
//             * 说明比m小的都在前半段，包括最小值。
//             */
//            return findMinHelper(nums, start, midpos - 1);
//        }
//    }
}
