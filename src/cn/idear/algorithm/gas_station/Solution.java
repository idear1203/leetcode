package cn.idear.algorithm.gas_station;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int start = -1;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            /**
             * 只有当sum < 0时start才会发生变化；换言之，如果sum一直大于等于0，start就不发生变化。
             */
            if(sum < 0){
                sum = 0;
                start = i;
            }
        }
        return total >= 0 ? start + 1 : -1;
    }

    /**
     * TLE
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        if(cost.length == 0)
            return -1;
        for(int i = 0; i < cost.length; i++){
            int sum = 0;
            int j;
            for(j = 0 ; j < cost.length; j++){
                sum += gas[(i + j) % cost.length] - cost[(i + j) % cost.length];
                if(sum < 0)
                    break;
            }
            if(j == cost.length)
                return i;
        }
        return -1;
    }
}
