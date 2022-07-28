package Queue;

import java.util.Stack;

public class BasicQueue {
    private int capacity;
    private int front;
    private int size;
    private Integer[] queue;
    private Stack<Integer> stack;

    public BasicQueue(int capacity) {
        this.capacity = capacity;
        front = 0;
        size = 0;
        queue = new Integer[capacity];
        stack = new Stack<>();
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void incrementSize() {
        size++;
    }

    private int getIndexToEnterElement() {
        return (front + size) % capacity;
    }

    private void incrementFrontIndex() {
        front = (front + 1) % capacity;
    }

    private void decrementSize() {
        size--;
    }

    private void storeInStack(int k) {
        for (int i = 1; i <= k; i++) {
            stack.push(dequeue());
        }
    }

    private void transferFromStack(BasicQueue newQueue) {
        while (!stack.empty()) {
            newQueue.enqueue(stack.pop());
        }
    }

    private void transferBetweenQueues(BasicQueue newQueue) {
        while (!this.isEmpty()) {
            newQueue.enqueue(this.dequeue());
        }
    }

    public void enqueue(Integer elementToEnter) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue[getIndexToEnterElement()] = elementToEnter;
        System.out.println("Enqueued element" + elementToEnter + " at index " + getIndexToEnterElement());
        incrementSize();
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return null;
        }
        Integer elementToDeque = queue[front];
        queue[front] = null; // For garbage collection
        incrementFrontIndex();
        decrementSize();
        return elementToDeque;
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("Empty queue");
        }
        System.out.println(queue[front]);
    }

    public int size() {
        return size;
    }

    public void emptyQueue() {
        while (!isEmpty()) {
            dequeue();
        }
        front();
    }

    public void reverse() {
        storeInStack(size());
        transferFromStack(this);
    }

    public void reverseKElements(int k) {
        if (k > size()) {
            return;
        }

        storeInStack(k);

        BasicQueue newQueue = new BasicQueue(size() + k);

        transferFromStack(newQueue);

        transferBetweenQueues(newQueue);

        this.queue = newQueue.queue;
    }

    public void queueStatus() {
        for (int i = 0; i < this.queue.length; i++) {
            System.out.print(this.queue[i] + ", ");
        }
    }

    public static void main(String args[]) {
        BasicQueue queue = new BasicQueue(10);

        // Adding 10 elements
        System.out.println("Adding 10 elements");
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        // // Trying to add at full capacity
        // queue.enqueue(29);

        // // Inspecting front and size
        // queue.front();
        // queue.size();

        // // Dequeueing and then enqueueing
        // queue.dequeue();
        // queue.enqueue(7);

        // System.out.println("Size now");
        // queue.size();

        // // Dequeueing all elements and then checking front
        // queue.emptyQueue();

        queue.reverseKElements(5);

        queue.queueStatus();
    }
}
