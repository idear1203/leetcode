package cn.idear.algorithm.restore_ip_address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 9/9/15.
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String path = "";
        restoreIpAddressesHelper(s, result, path, 0, 0);
        return result;
    }

    private void restoreIpAddressesHelper(String s, List<String> result, String path, int step, int index) {
        int len = s.length();
       if(step == 4){
           /**
            * find a valid ip address
            */
           if(index == len)
               result.add(path);
       }else{
           if(len - index > (4 - step) * 3)
               return;
           if(len - index < 4 - step)
               return;
           int num = 0;
           for(int i = index; i < 3 + index; i++){
               if(i == len)
                   break;
               num = num * 10 + s.charAt(i) - '0';
               if(num < 256)
                   restoreIpAddressesHelper(s, result, step == 3 ? path + num : path + num + '.', step + 1, i + 1);
               /**
                * 不能存在前导0
                */
               if(num == 0) break;
           }
       }
    }
}
