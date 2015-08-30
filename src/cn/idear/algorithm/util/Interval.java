package cn.idear.algorithm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Interval {
    public int start;
    public int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval interval = (Interval) o;

        if (start != interval.start) return false;
        return end == interval.end;

    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public String toString() {
        return "[" + start +"," +  end + "]";
    }

    public static List<Interval> createIntervals(int[][] nums){
        List<Interval> intervals = new ArrayList<>();
        for (int[] num : nums) {
            assert num.length == 2;
            intervals.add(new Interval(num[0], num[1]));
        }
        return intervals;
    }
}
