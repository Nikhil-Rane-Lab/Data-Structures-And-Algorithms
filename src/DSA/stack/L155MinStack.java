package DSA.stack;

import java.util.Stack;

public class L155MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public L155MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        // If the value is the same as the top of the min stack,
        // pop from the min stack as well
        // (since it means the minimum value is removed from the main stack).
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    //TC: O(1) because all operations (push, pop, top, getMin) are O(1).
    //SC: O(N) because in the worst case, every element could be added to both the main stack and the min stack.
}
