package cn.idear.algorithm.implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by idear on 15-11-2.
 */
public class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> list = new LinkedList<>();
        list.offer(x);
        while(!queue.isEmpty()){
            list.offer(queue.poll());
        }
        queue = list;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}
