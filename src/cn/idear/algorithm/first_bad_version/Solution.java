package cn.idear.algorithm.first_bad_version;

/**
 * Created by wangdongwei on 10/1/15.
 */

public class Solution extends VersionControl {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public int firstBadVersion(int n){
        int start = 1;
        int end = n;
        /**
         * 这种通过last找边沿的方式非常值得学习。！！！
         */
        int last = 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                last = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return last;
    }

    public int firstBadVersion1(int n) {
        int start = 1;
        int end = n;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                if(mid == 1 || !isBadVersion(mid - 1))
                    return mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return start;
    }
}
