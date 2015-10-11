package cn.idear.algorithm.repeated_dna_sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangdongwei on 10/11/15.
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length; i++)
            ss[i] = toNumber(ss[i]);
        int[] table = new int[(1<<20)];
        for(int i = 0; i < ss.length - 9; i++){
            int index = calIndex(ss, i);
            table[index]++;
            if(table[index] == 2)
                result.add(s.substring(i, i + 10));
        }
        return result;
    }

    private int calIndex(char[] ss, int start) {
        /**
         * 学习String.copyValueOf和Integer.parseInt(String, int)
         */
        String str = String.copyValueOf(ss, start, 10);
        return Integer.parseInt(str, 4);
    }

    private char toNumber(char ch) {
        switch (ch){
            case 'A': return '0';
            case 'C': return '1';
            case 'G': return '2';
            case 'T': return '3';
        }
        return 0;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        /**
         * 改成LinkedList不能通过。memory limit exceeded.
         */
        List<String> result = new ArrayList<>();
        Set<String> visit = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++){
            String str = s.substring(i, i + 10);
            if(visit.contains(str)){
                if(!result.contains(str))
                    result.add(str);
            }else{
                visit.add(str);
            }
        }
        return result;
    }
}
