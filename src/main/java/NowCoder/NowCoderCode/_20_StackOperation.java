package main.java.NowCoder.NowCoderCode;

import java.util.Stack;

/**
 * Created by Rinchar on 2018/3/15.
 */
public class _20_StackOperation {

    private Stack<Integer> stack_all = new Stack<>();
    private Stack<Integer> stack_min = new Stack<>();
    private int temp = Integer.MAX_VALUE;

    public void push(int node) {
        stack_all.push(node);
        if (node < temp) {
            stack_min.push(node);
            temp = node;
        }
    }

    public void pop() {
        if (stack_all.pop() == temp) stack_min.pop();
    }

    public int top() {
        return stack_all.peek();
    }

    public int min() {
        return stack_min.peek();
    }
}
