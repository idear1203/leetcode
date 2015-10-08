package cn.idear.algorithm.first_bad_version;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class VersionControl {

    private int firstBadVersion;

    public void setFirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    boolean isBadVersion(int n) {
        return n >= firstBadVersion;
    }
}
