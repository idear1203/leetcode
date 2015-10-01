package cn.idear.algorithm.util;

import java.util.*;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public  UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }

    public static UndirectedGraphNode make(int[] nums){
        return make(nums, -1);
    }

    private static UndirectedGraphNode make(int[] nums, int replacement) {
        if(nums.length == 0)
            return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != replacement) {
                UndirectedGraphNode node = getNode(nums[i], map);
                for(i = i + 1; i < nums.length && nums[i] != replacement; i++){
                   node.neighbors.add(getNode(nums[i], map));
                }
            }
        }
        return map.get(nums[0]);
    }

    private static  UndirectedGraphNode getNode(int label, Map<Integer, UndirectedGraphNode> map){
        UndirectedGraphNode node = map.get(label);
        if (node == null) {
            node = new UndirectedGraphNode(label);
            map.put(label, node);
        }
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UndirectedGraphNode that = (UndirectedGraphNode) o;

        return equalsHelper(this, that, new HashSet<UndirectedGraphNode>());
    }

    private boolean equalsHelper(UndirectedGraphNode node, UndirectedGraphNode that,
                                 HashSet<UndirectedGraphNode> visits) {
        if(visits.contains(node))
            return true;
        if (node.label != that.label)
            return false;
        if(node.neighbors.size() != that.neighbors.size())
            return false;
        visits.add(node);
        for(int i = 0; i < node.neighbors.size(); i++){
            UndirectedGraphNode n1 = node.neighbors.get(i);
            UndirectedGraphNode n2 = that.neighbors.get(i);
            if(!equalsHelper(n1, n2, visits))
                return false;
        }
        visits.remove(node);
        return true;
    }

    @Override
    public int hashCode() {
        return label;
    }
}
