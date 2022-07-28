package Stack;

import java.util.Stack;

public class MaxElement {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    private int max = Integer.MIN_VALUE;

    public MaxElement() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    private void setMax(int valueToSet) {
        max = valueToSet;
    }

    private void updateMax(Integer valueToComapare) {
        max = Math.max(max, (int) valueToComapare);
    }

    public void popFromStack() {
        stack.pop();
        removeFromMaxStack();
    }

    private void removeFromMaxStack() {
        maxStack.pop();
        setMax((int) maxStack.peek());
    }

    private void addToMaxStack(Integer valueAdded) {
        updateMax(valueAdded);
        maxStack.push(max);
    }

    public void pushToStack(Integer elementToPush) {
        stack.push(elementToPush);
        addToMaxStack(elementToPush);
    }

    public void getMaximumElement() {
        if (maxStack.isEmpty()) {
            System.out.println("The stack is empty");
            return;
        }
        maxStack.peek();
    }
}
