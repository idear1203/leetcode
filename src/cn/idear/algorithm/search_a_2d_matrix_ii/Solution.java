package cn.idear.algorithm.search_a_2d_matrix_ii;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        return searchMatrixHelper(matrix, target, 0, m - 1, 0, n - 1);
    }

    private boolean searchMatrixHelper(int[][] matrix, int target, int xs, int xe, int ys, int ye) {
        if(xs == xe && ys == ye)
            return matrix[xs][ys] == target;
        else if(xs <= xe && ys <= ye){
            int xm = (xs + xe) >> 1;
            int ym = (ys + ye) >> 1;
            int mid = matrix[xm][ym];
            if(target == mid)
                return true;
            else if(target > mid) {
                return searchMatrixHelper(matrix, target, xm + 1, xe, ys, ye)
                        || searchMatrixHelper(matrix, target, xs, xm, ym + 1, ye);
            }
            else {
                return searchMatrixHelper(matrix, target, xm, xe, ys, ym - 1)
                        || searchMatrixHelper(matrix, target, xs, xm - 1, ys, ye);
            }
        }
        return false;
    }
}
