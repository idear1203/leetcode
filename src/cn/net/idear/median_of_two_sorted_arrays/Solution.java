package cn.net.idear.median_of_two_sorted_arrays;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/24/15.
 There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
 The overall run time complexity should be O(log (m+n)).
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        /**
         * if length is even, return middle.
         */
        if((length & 0x01) != 0){
            return findKth(nums1,nums2,length/2 + 1);
        }else{
            return (findKth(nums1, nums2, length/2) +findKth(nums1, nums2, length/2 + 1)) / 2;
        }
    }

    /**
     * case nums1[k/2-1] < nums2[k/2 - 1]:
     *      说明第k大的数字不在nums1[0...k/2 - 1]中。否则假设kth在nums1[0...k/2-1]中，则必有kth<=nums1[k/2-1]<nums2[k/2-1]。
     *      对于nums1[0...k/2-1]与nums2[0...k/2-1]构成的集合，集合元素个数为k。由于这个集合中最大的数字是nums2[k/2-1]，因而kth一定
     *      不在集合尾部，故而Kth一定不是第k个元素。故而矛盾。
     *
     * case nums1[k/2-1] > nums2[k/2-1]:
     *      同理
     *
     * case nums1[k/2-1] == nums2[k/2-1]:
     *      同理可说明kth = nums1[k/2-1] = nums2[k/2-1]。
     *
     * -------------------------------
     *
     * 边界条件：
     *
     * 1. 某集合元素为空。不妨设nums1为空集合，则返回nums2[k-1]；
     *
     * 2. 要保证k/2 - 1 >=0，因而k>=2。当k = 1时，返回min(nums1[0],nums2[0])。
     *
     * 3. 当k >= nums1.length?
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    /**
     *  Accepted.
     */
    private double findKth(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0)
            return nums2[k - 1];
        if(nums2.length == 0)
            return nums1[k - 1];
        if(k == 1)
            return Math.min(nums1[0],nums2[0]);
        if(nums1.length > nums2.length)
            return findKth(nums2, nums1, k);
        int ai = Math.min(k / 2, nums1.length);
        int bi = k - ai;
        if(nums1[ai - 1] < nums2[bi - 1])
            return findKth(Arrays.copyOfRange(nums1,ai, nums1.length),
                    nums2, k - ai);
        else if(nums1[ai - 1] > nums2[bi - 1])
            return findKth(Arrays.copyOfRange(nums2, bi, nums2.length),
                    nums1, k - bi);
        return nums1[ai - 1];
    }
}
//public class  Solution{
//
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length = nums1.length + nums2.length;
//        if((length & 0x01) != 0){
//            return findKth(nums1, nums1.length, nums2, nums2.length, length / 2 + 1);
//        }
//        return (findKth(nums1, nums1.length, nums2, nums2.length, length/2)
//                + findKth(nums1, nums1.length, nums2, nums2.length, length/2 + 1)) / 2;
//    }
//
//    private double findKth(int[] nums1, int m, int[] nums2, int n, int k) {
//        if(m == 0)
//            return nums2[k - 1];
//        if(n == 0)
//            return nums1[k - 1];
//        if(k == 1)
//            return Math.min(nums1[0], nums2[0]);
//        /**
//         * 为什么不是if(m < n) 保证前面的尽可能少，后面的集合元素尽可能多
//         */
//        if(m > n)
//            return findKth(nums2, n, nums1, m, k);
//        /**
//         * 此处用个数比较好
//         */
//        int ai = Math.min(k / 2, m);
//        int bi = k - ai;
//        if(nums1[ai - 1] < nums2[bi - 1])
//            return findKth(Arrays.copyOfRange(nums1, ai, m),m - ai, nums2, n, k - ai);
//        else if(nums1[ai - 1] > nums2[bi - 1])
//            return findKth(Arrays.copyOfRange(nums2, bi, n),n - bi, nums1, m, k - bi);
//        return nums1[ai - 1];
//    }
//}
//public class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length = nums1.length + nums2.length;
//        /**
//         * if length is even, return middle.
//         */
//        if((length & 0x01) != 0){
//            return findKth(nums1,nums2,length/2 + 1);
//        }else{
//            return (findKth(nums1, nums2, length/2) +findKth(nums1, nums2, length/2 + 1)) / 2;
//        }
//    }
//
//    /**
//     * case nums1[k/2-1] < nums2[k/2 - 1]:
//     *      说明第k大的数字不在nums1[0...k/2 - 1]中。否则假设kth在nums1[0...k/2-1]中，则必有kth<=nums1[k/2-1]<nums2[k/2-1]。
//     *      对于nums1[0...k/2-1]与nums2[0...k/2-1]构成的集合，集合元素个数为k。由于这个集合中最大的数字是nums2[k/2-1]，因而kth一定
//     *      不在集合尾部，故而Kth一定不是第k个元素。故而矛盾。
//     *
//     * case nums1[k/2-1] > nums2[k/2-1]:
//     *      同理
//     *
//     * case nums1[k/2-1] == nums2[k/2-1]:
//     *      同理可说明kth = nums1[k/2-1] = nums2[k/2-1]。
//     *
//     * -------------------------------
//     *
//     * 边界条件：
//     *
//     * 1. 某集合元素为空。不妨设nums1为空集合，则返回nums2[k-1]；
//     *
//     * 2. 要保证k/2 - 1 >=0，因而k>=2。当k = 1时，返回min(nums1[0],nums2[0])。
//     *
//     * 3. 当k >= nums1.length?
//     *
//     * @param nums1
//     * @param nums2
//     * @param k
//     * @return
//     */
//    /**
//     *  Accepted.
//     */
//    private double findKth(int[] nums1, int[] nums2, int k) {
//        if(nums1.length == 0)
//            return nums2[k - 1];
//        if(nums2.length == 0)
//            return nums1[k - 1];
//        if(k == 1)
//            return Math.min(nums1[0],nums2[0]);
//        int mid1Index = Math.min(k/2 - 1,nums1.length - 1);
//        int nums1Mid = nums1[mid1Index];
//        /**
//         * mid2Index下标的选取是精髓。由于奇数的问题出现了wrong answer。这个除以2时要格外注意。
//         * 原因在于当k为奇数时 (k/2-1) + (k/2 -1) = k - 1而非k！
//         * 从nums1中取了nums1Index + 1个元素，故而应该从nums2中取k - (nums1Index + 1)个元素。
//         * 其下标范围为0...k - 1 - (nums1Index + 1)
//         */
//        int mid2Index = Math.min(k - 2 - mid1Index,nums2.length - 1);
//        int nums2Mid = nums2[mid2Index];
//        if(nums1Mid < nums2Mid)
//            return findKth(Arrays.copyOfRange(nums1,mid1Index + 1,nums1.length),
//                    nums2,k - mid1Index - 1);
//        else if(nums1Mid > nums2Mid)
//            return findKth(nums1,
//                    Arrays.copyOfRange(nums2, mid2Index + 1, nums2.length),k - mid2Index - 1);
//        return nums1Mid;
//    }
//}
