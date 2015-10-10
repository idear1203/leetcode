package cn.idear.algorithm.course_schedule_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by idear on 15-10-9.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)    return new int[0];
        List<List<Integer>> arcs = new LinkedList<>();
        int[] outDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            arcs.add(new ArrayList<Integer>());
        for(int[] prerequisite : prerequisites){
            arcs.get(prerequisite[0]).add(prerequisite[1]);
            outDegree[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(outDegree[i] == 0){
                /*
                 * 学习offer
                 */
                queue.offer(i);
            }
        }
        int count = 0;
        List<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()){
            int v = queue.poll();
            count++;
            result.add(v);
            for(int u : arcs.get(v)){
                outDegree[u]--;
                if(outDegree[u] == 0)
                    queue.offer(u);
            }
        }
        if(count != numCourses)
            return new int[0];
        int[] rst = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            rst[i] = result.get(numCourses - 1 - i);
        return rst;
    }
}
