package cn.idear.algorithm.search_a_2d_matrix;

/**
 * Created by wangdongwei on 8/30/15.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int e = m * n - 1;
        int s = 0;
        while (s <= e){
            int midpos = (s + e) >> 1;
            int num = getNumber(matrix, midpos, n);
            if(num == target)
                return true;
            else if(num > target)
                e = midpos - 1;
            else
                s = midpos + 1;
        }
        return false;
    }

    private int getNumber(int[][] matrix, int index, int n){
        return matrix[index / n][index % n];
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int line = m - 1;
        for(int i = 0; i < m; i++) {
            if (target < matrix[i][0]) {
                line = i - 1;
                break;
            }else if(target == matrix[i][0])
                return true;
        }
        if(line == -1 || n == 1 || target > matrix[line][n - 1])
            return false;
        return searchBinary(matrix[line], target, 1, n - 1);
    }

    private boolean searchBinary(int[] nums, int target, int s, int e) {
        if(s == e)
            return target == nums[s];
        else if(s < e){
            int mid = (s + e) >> 1;
            int m = nums[mid];
            if(m == target)
                return true;
            else if(m > target)
                return searchBinary(nums, target, s, mid - 1);
            else
                return searchBinary(nums, target, mid + 1, e);
        }
        return false;
    }
}
