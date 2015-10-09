package cn.idear.algorithm.course_schedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by idear on 15-10-9.
 */
public class Solution {
    /**
     * 学习通过拓扑排序来判定有向图是否存在环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 || numCourses == 0)   return true;
        List<List<Integer>> arcs = new LinkedList<>();
        int[] outDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            arcs.add(new ArrayList<Integer>());
            outDegree[i] = 0;
        }
        for(int[] prerequisite : prerequisites){
            arcs.get(prerequisite[0]).add(prerequisite[1]);
            outDegree[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(outDegree[i] == 0)
                queue.add(i);
        int count = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            count++;
            for(int u : arcs.get(v)){
                outDegree[u]--;
                if(outDegree[u] == 0){
                    queue.offer(u);
                }
            }
        }
        return count == numCourses;
    }
}
