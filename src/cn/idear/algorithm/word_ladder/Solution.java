package cn.idear.algorithm.word_ladder;

import java.util.*;

/**
 * Created by wangdongwei on 10/1/15.
 */
//TODO:
public class Solution {

    /**
     * Dijkstra version. Time Limit Exceeded.
     */
    private class Graph{
        Map<String, Vertex> map = new HashMap<>();
        int size = 0;

        private void addVertex(String key){
            Vertex vertex = map.get(key);
            if(vertex == null) {
                vertex = new Vertex(key);
                map.put(key, vertex);
            }
        }

        private int size(){
            if(size == 0) {
                size = map.values().size();
            }
            return size;
        }

        private Collection<Vertex> getVertexes(){
            return map.values();
        }

        private Vertex getVertex(String key){
            return map.get(key);
        }
    }

    private class Vertex{
        String word;
        Set<Vertex> succs = new HashSet<>();
        public Vertex(String word) {
            this.word = word;
        }
        private void addSucc(Vertex succ){
            succs.add(succ);
        }

        public Set<Vertex> getSuccs() {
            return succs;
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        Graph graph = constructGraph(beginWord, endWord, wordList);
        int distance = shortest(graph, beginWord, endWord);
        return distance == Integer.MAX_VALUE ? 0 : distance + 1;
    }

    private int shortest(Graph graph, String beginWord, String endWord) {
        Map<Vertex, Integer> map = new HashMap<>();
        Vertex start = graph.getVertex(beginWord);
        Vertex end = graph.getVertex(endWord);
        int size = graph.size();
        /**
         *  1. 初始时令 S={V0},T=V-S={其余顶点}
         */
        Set<Vertex> s = new HashSet<>();
        s.add(start);
        /**
         * 若存在<V0,Vi>，d(V0,Vi)为<V0,Vi>弧上的权值
         * 若不存在<V0,Vi>，d(V0,Vi)为∞
         */
        for (Vertex vertex : graph.getVertexes())
            if (vertex == start)
                map.put(vertex, 0);
            else if(start.succs.contains(vertex))
                map.put(vertex, 1);
            else
                map.put(vertex, Integer.MAX_VALUE);
        /**
         * 2. 从T中选取一个与S中顶点有关联边且权值最小的顶点W，加入到S中
         */
        for(int i = 1; i < size; i++){
            Vertex w = null;
            int min = Integer.MAX_VALUE;
            for(Vertex vertex : graph.getVertexes()){
                if(!s.contains(vertex) && min > map.get(vertex)) {
                    min = map.get(vertex);
                    w = vertex;
                }
            }
            if(w == null)
                return Integer.MAX_VALUE;
            if(w == end)
                return min;
            s.add(w);
            /**
             * 3. 对其余T中顶点的距离值进行修改：若加进W作中间顶点，从V0到Vi的距离值缩短，则修改此距离值
             */
            for(Vertex succ : w.succs){
                if(!s.contains(succ)){
                    int distance = map.get(succ);
                    if(distance > 1 + min){
                        map.put(succ, 1 + min);
                    }
                }
            }
        }
        return map.get(end);
    }

    private Graph constructGraph(String beginWord, String endWord, Set<String> wordList) {
        Graph graph = new Graph();
        graph.addVertex(beginWord);
        graph.addVertex(endWord);
        for(String word : wordList)
            graph.addVertex(word);
        Vertex[] vertexes = new Vertex[wordList.size()];
        vertexes = graph.getVertexes().toArray(vertexes);
//        for(int i = 0; i < vertexes.length - 1; i++){
//            Vertex vi = vertexes[i];
//            for(int j = i + 1; j < vertexes.length; j++){
//                Vertex vj = vertexes[j];
//                if(distance(vi, vj) == 1){
//                    vi.addSucc(vj);
//                    vj.addSucc(vi);
//                }
//            }
//        }
        for(int i = 0; i < vertexes.length; i++){
            char[] chars = vertexes[i].word.toCharArray();
            for(int j = 0; j < chars.length; j++){
                char ch = chars[j];
                for(char k = 'a'; k <= 'z'; k++){
                    if(k != ch){
                        chars[j] = k;
                        String s = new String(chars);
                        if(wordList.contains(s) || s.equals(endWord))
                            vertexes[i].succs.add(graph.getVertex(s));
                        chars[j] = ch;
                    }
                }
            }
        }
        return graph;
    }

    private int distance(Vertex vi, Vertex vj) {
        if(vi == vj)
            return 0;
        int len = vi.word.length();
        int count = 0;
        for(int i = 0; i < len; i++)
            if(vi.word.charAt(i) != vj.word.charAt(i)) {
                count++;
                if(count > 1)
                    return count;
            }
        return count;
    }
}
