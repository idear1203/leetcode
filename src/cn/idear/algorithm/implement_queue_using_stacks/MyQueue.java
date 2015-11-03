package cn.idear.algorithm.implement_queue_using_stacks;

import java.util.Stack;

/**
 * Created by idear on 15-11-3.
 */
public class MyQueue {
    Stack<Integer> stack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> swap = new Stack<>();
        while(!stack.isEmpty())
            swap.push(stack.pop());
        swap.push(x);
        while(!swap.isEmpty())
            stack.push(swap.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
