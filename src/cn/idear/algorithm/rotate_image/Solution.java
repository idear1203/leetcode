package cn.idear.algorithm.rotate_image;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/28/15.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        rotateHelper(matrix, 0, n);
    }

    private void rotateHelper(int[][] matrix, int start, int end) {
        if(start < end){
            /**
             * 先旋转里圈。
             */
            rotateHelper(matrix, start + 1, end - 1);
            /**
             * 旋转最外圈。
             */
            for(int i = 0; i < end - start; i++) {
                int pivot = matrix[start + i][start];
                matrix[start + i][start] = matrix[end][start + i];
                matrix[end][start + i] = matrix[end - i][end];
                matrix[end - i][end] = matrix[start][end - i];
                matrix[start][end - i] = pivot;
            }
        }
    }
}
