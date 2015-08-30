package cn.idear.algorithm.insert_interval;

import cn.idear.algorithm.util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdongwei on 8/30/15.
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int pos = intervals.size();
        for(int i = 0; i < intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(newInterval.start <= interval.start){
                pos = i;
                break;
            }
        }
        intervals.add(pos, newInterval);
        List<Interval> result = merge(intervals);
        return result;
    }

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Stack<Interval> stack = new Stack<>();
        for(int i = intervals.size() - 1; i >= 0; i--)
            stack.push(intervals.get(i));
        while(stack.size() > 1){
            Interval first = stack.pop();
            Interval second = stack.pop();
            if(canMerge(first, second)){
                Interval newInterval = mergeTwo(first, second);
                stack.push(newInterval);
            }else{
                result.add(first);
                stack.push(second);
            }
        }
        result.addAll(stack);
        return result;
    }

    private boolean canMerge(Interval first, Interval second) {
        return second.start <= first.end;
    }

    private Interval mergeTwo(Interval first, Interval second) {
        return new Interval(first.start, Math.max(first.end, second.end));
    }
}
