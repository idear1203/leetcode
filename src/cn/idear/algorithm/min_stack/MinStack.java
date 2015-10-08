package cn.idear.algorithm.min_stack;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class MinStack {
    private class MinNode{
        MinNode next;
        int x;
    }

    private class Stack{

        private MinNode dummy = new MinNode();

        int size = 0;

        private void push(int x){
            MinNode node = new MinNode();
            node.x = x;
            node.next = dummy.next;
            dummy.next = node;
            size++;
        }

        private void pop(){
            if(dummy.next != null){
                dummy.next = dummy.next.next;
                size--;
            }
        }

        private int top(){
            if(dummy.next != null){
                return dummy.next.x;
            }
            throw new RuntimeException();
        }

        private int size(){
            return size;
        }
    }

    private Stack data = new Stack();
    private Stack min = new Stack();

    public void push(int x) {
        data.push(x);
        if(min.size() == 0 || x <= getMin()){
            min.push(x);
        }
    }

    public void pop() {
        int x = data.top();
        data.pop();
        /**
         * 注意必须用<=否则会发生无法弹栈的错误。
         * test case : push(2),push(0),push(3),push(0),getMin,pop,getMin,pop,getMin,pop,getMin
         */
        if(min.size() > 0 && x <= getMin())
            min.pop();
    }

    public int top() {
        return data.top();
    }

    public int getMin() {
        return min.top();
    }
}
