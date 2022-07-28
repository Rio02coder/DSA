package Stack;

import java.util.Stack;

/**
 * This is a program to implement a queue with a stack
 */

public class Queue<E> {
    private Stack<E> queue;
    private Stack<E> auxiliaryStack;

    public Queue() {
        queue = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    private void transfer(Stack<E> stack1, Stack<E> stack2) {
        while (!stack1.empty()) {
            stack2.add(stack1.pop());
        }
    }

    public void enqueue(E element) {
        transfer(queue, auxiliaryStack);
        queue.add(element);
        transfer(auxiliaryStack, queue);
    }

    public E dequeue() {
        if (queue.empty()) {
            return null;
        }
        return queue.pop();
    }

    public E front() {
        if (queue.empty()) {
            return null;
        }
        return queue.peek();
    }
}
