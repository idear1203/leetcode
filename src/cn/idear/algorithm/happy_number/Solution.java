package cn.idear.algorithm.happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangdongwei on 8/24/15.
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 1^2 + 9^2 = 82
 8^2 + ^22 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 */
public class Solution {
 public boolean isHappy(int n) {
  Set<Integer> happySet = new HashSet<Integer>();
  return isHappyHelper(n, happySet);
 }

 private boolean isHappyHelper(int n, Set<Integer> happySet) {
  if(n == 1)
   return true;
  if(happySet.contains(n))
   return false;
  happySet.add(n);
  return isHappyHelper(getDigitSquareSum(n), happySet);
 }

 private int getDigitSquareSum(int n) {
  if(n == 0)
   return 0;
  int sum = 0;
  while(n > 0){
   int digit = n % 10;
   sum += Math.pow(digit, 2);
   n = n / 10;
  }
  return sum;
 }
}
