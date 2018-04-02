package main.java.NowCoder.NowCoderCode;

import java.util.Stack;

/**
 * Created by Rinchar on 2018/3/8.
 */
public class _5_QueuePushPop {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        while (stack1.size() != 0) {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        stack1.push(node);
        while (stack2.size() != 0) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
    }

    public int pop() {
        int re = stack1.peek();
        stack1.pop();
        return re;
    }
}
