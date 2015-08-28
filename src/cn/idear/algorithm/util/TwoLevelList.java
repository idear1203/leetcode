package cn.idear.algorithm.util;

import java.util.*;

/**
 * Created by wangdongwei on 8/28/15.
 */
public class TwoLevelList<T> {

    Set<List<T>> set;

    int size;

    private TwoLevelList() {
        set = new HashSet<>();
    }

    public static <T> TwoLevelList<T> make(List<List<T>> list){
        TwoLevelList<T> twoLevelTList = new TwoLevelList<>();
        twoLevelTList.size = list.size();
        twoLevelTList.set.addAll(list);
        return twoLevelTList;
    }

    public static <T> TwoLevelList<T> make(T[][] nums){
        List<List<T>> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            List<T> list = new ArrayList<>();
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

        TwoLevelList that = (TwoLevelList) o;

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
        return "TwoLevelList{" +
                "set=" + set +
                ", size=" + size +
                '}';
    }
}
