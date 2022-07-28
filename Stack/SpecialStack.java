package Stack;

import java.util.Stack;

public class SpecialStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public SpecialStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    private void enqueueToMinStack(Integer e) {
        if (minStack.peek() < e) {
            minStack.add(minStack.peek());
            return;
        }
        minStack.add(e);
    }

    public void enqueue(Integer e) {
        stack.add(e);
        enqueueToMinStack(e);
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public Integer dequeue() {
        minStack.pop();
        return stack.pop();
    }

    public Integer getTop() {
        return stack.peek();
    }
}
