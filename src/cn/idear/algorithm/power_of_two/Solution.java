package cn.idear.algorithm.power_of_two;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 &&  (n & n - 1) == 0;
    }
}
