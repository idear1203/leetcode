package cn.idear.algorithm.string_to_integer;

/**
 * Created by wangdongwei on 8/25/15.
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 */

/**
 * 注意溢出、不正确输入等问题。
 */
public class Solution {
    private enum State{
        INIT,
        NUMBER,
        END
    }

    public int myAtoi(String str) {
        str = str.trim();
        long rst = 0;
        State state = State.INIT;
        int i = 0;
        boolean neg = false;
        while(state != State.END){
            char ch = 'a';
           if(i < str.length())
               ch = str.charAt(i++);
            else
               state = State.END;
            switch (state){
                case INIT:
                    if(ch == '-'){
                        neg = true;
                        state = State.NUMBER;

                    }else if(ch == '+')
                        state = State.NUMBER;
                    else if(Character.isDigit(ch)){
                       rst = ch - '0';
                        state = State.NUMBER;
                    }else
                        state = State.END;
                    break;

                case NUMBER:
                    if(Character.isDigit(ch)){
                        rst = rst * 10 + ch - '0';
                        if(rst > Integer.MAX_VALUE)
                            return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }else
                        state = State.END;
                    break;

                default:
                    break;
            }
        }
        return (int) (neg ? -rst : rst);
    }
}
