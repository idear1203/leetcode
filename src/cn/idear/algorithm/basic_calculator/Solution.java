package cn.idear.algorithm.basic_calculator;

import java.util.Stack;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public int calculate(String s) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length; i++){
            char ch = ss[i];
            switch (ch){

                case ' ':
                    break;

                case '+':case '-':case '(':
                    opStack.push(ch);
                    break;

                case ')':
                    /**
                     * 计算至最近匹配的(
                     */
                    for(char op = opStack.pop(); op != '('; op = opStack.pop()){
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        int rst = basicCalculate(op, num1, num2);
                        numStack.push(rst);
                    }
                    while(!opStack.isEmpty()){
                        char op = opStack.peek();
                        if(op == '(') break;
                        opStack.pop();
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        int rst = basicCalculate(op, num1, num2);
                        numStack.push(rst);
                    }
                    break;

                /**
                 * number
                 */
                default:
                    int num = ch - '0';
                    while(i + 1 < ss.length && Character.isDigit(ss[i + 1])){
                        num = (ss[i + 1] - '0') + num * 10;
                        i++;
                    }
                    numStack.push(num);
                    while(!opStack.isEmpty() && opStack.peek() != '('){
                        char op = opStack.pop();
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        int rst = basicCalculate(op, num1, num2);
                        numStack.push(rst);
                    }
                    break;
            }
        }
        return numStack.isEmpty() ? 0 : numStack.peek();
    }

    private int basicCalculate(char op, int num1, int num2) {
        switch (op){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return 0;
        }
    }
}
