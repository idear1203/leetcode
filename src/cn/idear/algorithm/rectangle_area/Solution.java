package cn.idear.algorithm.rectangle_area;

/**
 * Created by idear on 15-11-2.
 */
public class Solution {
    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = calArea(A, B, C, D) + calArea(E, F, G, H);
        /**
         * make sure left is left.
         */
        if(A > E){
            return computeArea(E, F, G, H, A, B, C, D);
        }
        /**
         * 不相交的情形
         */
        if(H < B || C < E || D < F)
            return total;
        /**
         * 相交的情形
         */
        return total - calArea(E, Math.max(B, F), Math.min(C, G), Math. min(D, H));
    }

    private int calArea(int a, int b, int c, int d){
        return (c - a) * (d - b);
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = calArea(A, B, C, D) + calArea(E, F, G, H);
        if(A >= G || B >= H || C <= E || D <= F) return total;
        return total - calArea(Math.max(A, E), Math.max(B, F),  Math.min(C, G) , Math.min(D, H));
    }
}
