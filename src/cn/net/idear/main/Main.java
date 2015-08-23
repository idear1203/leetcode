package cn.net.idear.main;

import cn.net.idear.add_two_numbers.ListNode;
import cn.net.idear.two_sum.Solution;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static java.lang.String.*;

/**
 * Created by wangdongwei on 8/23/15.
 */
public class Main {
    @Test
    public  void  testPlusOne(){
        String rst;
        rst = plusOne(new int[]{9,9,9});
        Assert.assertEquals("1000", rst);

        rst = plusOne(new int[]{1,0});
        Assert.assertEquals("11", rst);
    }

    @Test
    public void testMultiplyString(){
        String rst ;
        rst = multiplyString("25", "25");
        System.out.println(rst);
        Assert.assertEquals("625", rst);

        rst = multiplyString("0", "0");
        System.out.println(rst);
        Assert.assertEquals("0", rst);

        rst = multiplyString("0", "1");
        System.out.println(rst);
        Assert.assertEquals("0", rst);

        rst = multiplyString("256", "16");
        System.out.println(rst);
        Assert.assertEquals("4096", rst);

        rst = multiplyString("123", "456");
        System.out.println(rst);
        Assert.assertEquals("56088", rst);
    }


    @Test
    public void testAddBinary(){
        String rst;
        rst = addBinary("11","1");
        System.out.println(rst);
        Assert.assertEquals("100",rst);

        rst = addBinary("0","0");
        System.out.println(rst);
        Assert.assertEquals("0",rst);
    }

    @Test
    public void testTwoSum(){
        String rst;
        rst = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(rst);
        rst = rst.replaceAll(" ","");
        Assert.assertEquals("12", rst);
    }

    @Test
    public void testAddTwoNumbers(){
        String rst;
        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6, 4});
        System.out.println(rst);
        rst = rst.replaceAll(" ","");
        Assert.assertEquals("708",rst);

        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6});
        System.out.println(rst);
        rst = rst.replaceAll(" ","");
        Assert.assertEquals("704",rst);

        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6, 6});
        System.out.println(rst);
        rst = rst.replaceAll(" ","");
        Assert.assertEquals("7001",rst);
    }

    private static  String twoSum(int[] nums , int target){
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();
        int[] rst = solution.twoSum(nums, target);
        for(int i = 0; i < rst.length; i++)
            sb.append(rst[i] + " ");
        return sb.toString();
    }

    private static String addTwoNumbers(int[] l1, int[] l2){
        StringBuilder sb = new StringBuilder();
        ListNode n1 = createList(l1);
        ListNode n2 = createList(l2);
        cn.net.idear.add_two_numbers.Solution solution = new cn.net.idear.add_two_numbers.Solution();
        ListNode rst = solution.addTwoNumbers(n1, n2);
        for(ListNode n = rst; n != null; n = n.next) {
            sb.append(n.val + " ");
        }
        return sb.toString();
    }

    private static ListNode createList(int [] list){
        ListNode dummy = new ListNode(-1);
        ListNode l = dummy;
        for(int i = 0; i < list.length; i++, l = l.next){
            l.next = new ListNode(list[i]);
        }
        return dummy.next;
    }

    private static String addBinary(String a, String b){
        cn.net.idear.add_binary.Solution solution = new cn.net.idear.add_binary.Solution();
        return solution.addBinary(a,b);
    }

    private String multiplyString(String num1, String num2) {
        cn.net.idear.multiply_string.Solution solution = new cn.net.idear.multiply_string.Solution();
        return solution.multiply(num1,num2);
    }

    private String plusOne(int[] digits) {
        cn.net.idear.plus_one.Solution solution = new cn.net.idear.plus_one.Solution();
        int[] rst = solution.plusOne(digits);
        String str = "";
        for(int i = 0; i < rst.length; i++)
            str += rst[i];
        return str;
    }

}
