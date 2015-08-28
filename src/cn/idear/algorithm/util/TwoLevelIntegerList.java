package cn.idear.algorithm.util;

import java.util.*;

/**
 * Created by wangdongwei on 8/28/15.
 */
public class TwoLevelIntegerList {

    Set<List<Integer>> set;

    int size;

    private TwoLevelIntegerList() {
        set = new HashSet<>();
    }

    public static TwoLevelIntegerList make(List<List<Integer>> list){
        TwoLevelIntegerList twoLevelIntegerList = new TwoLevelIntegerList();
        twoLevelIntegerList.size = list.size();
        twoLevelIntegerList.set.addAll(list);
        return twoLevelIntegerList;
    }

    public static TwoLevelIntegerList make(int[][] nums){
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums[i].length; j++)
                list.add(nums[i][j]);
            ret.add(list);
        }
        return make(ret);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwoLevelIntegerList that = (TwoLevelIntegerList) o;

        if (size != that.size) return false;
        return !(set != null ? !set.equals(that.set) : that.set != null);

    }

    @Override
    public int hashCode() {
        int result = set != null ? set.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "TwoLevelIntegerList{" +
                "set=" + set +
                ", size=" + size +
                '}';
    }
}
