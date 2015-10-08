package cn.idear.algorithm.clone_graph;

import cn.idear.algorithm.util.UndirectedGraphNode;

import java.util.*;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Set<Integer> visits = new HashSet<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            UndirectedGraphNode n = stack.pop();
            if(!visits.contains(n.label)){
                visits.add(n.label);
                UndirectedGraphNode newNode = getNode(n.label);
                for(UndirectedGraphNode neighbor : n.neighbors){
                    newNode.neighbors.add(getNode(neighbor.label));
                    stack.add(neighbor);
                }
            }
        }
        return getNode(node.label);
    }

    private UndirectedGraphNode getNode(int label){
        UndirectedGraphNode node = map.get(label);
        if(node == null){
            node = new UndirectedGraphNode(label);
            map.put(label, node);
        }
        return node;
    }
}
