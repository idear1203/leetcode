package cn.idear.algorithm.merge_intervals;

import cn.idear.algorithm.util.Interval;

import java.util.*;

/**
 * Created by wangdongwei on 8/30/15.
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class Solution {

    /**
     * Accepted. 栈。
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o2.start - o1.start;
            }
        });
        Stack<Interval> stack = new Stack<>();
        stack.addAll(intervals);
        while(stack.size() > 1){
            Interval interval1 = stack.pop();
            Interval interval2 = stack.pop();
            if(canMerge(interval1, interval2)){
                Interval mergeInterval = mergeTwo(interval1, interval2);
                stack.push(mergeInterval);
            }else{
                result.add(interval1);
                stack.push(interval2);
            }
        }
        result.addAll(stack);
        return result;
    }

    private Interval mergeTwo(Interval interval1, Interval interval2) {
        return new Interval(interval1.start, Math.max(interval1.end, interval2.end));
    }

    private boolean canMerge(Interval interval1, Interval interval2) {
        return interval2.start <= interval1.end;
    }
}
