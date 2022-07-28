package Queue;

public class Deque {
    private int capacity;
    private int front;
    private int rear;
    private int size;
    private Integer deque[];

    public Deque(int capacity) {
        this.capacity = capacity;
        front = -1;
        rear = -1;
        size = 0;
        deque = new Integer[capacity];
    }

    private void setFront(int number) {
        front = number;
    }

    private void setRear(int number) {
        rear = number;
    }

    private void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    private void incrementRear() {
        setRear((rear + 1) % capacity);
    }

    private void decrementFront() {
        setFront((front + 1) % capacity);
    }

    private void incrementFront() {
        setFront((front - 1 + capacity) % capacity);
    }

    private void decrementRear() {
        setRear((rear - 1 + capacity) % capacity);
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private Integer retrieveElementAtIndex(int index) {
        return deque[index];
    }

    private void setElementAtIndex(int index, Integer elementToSet) {
        deque[index] = elementToSet;
    }

    private void resetFrontAndRear() {
        setFront(-1);
        setRear(-1);
    }

    private void setFrontAndRearToFirstIndex() {
        setFront(0);
        setRear(0);
    }

    private void displayQueue() {
        for (int i = 0; i < size; i++) {
            System.out.print(retrieveElementAtIndex(i) + " ");
        }
    }

    private void setFrontIndexForInsertion() {
        if (isEmpty()) {
            setFrontAndRearToFirstIndex();
            return;
        }
        incrementFront();
    }

    private void setRearIndexForInsertion() {
        if (isEmpty()) {
            setFrontAndRearToFirstIndex();
            return;
        }
        incrementRear();
    }

    private void setRearIndexAfterDeletion() {
        if (size == 1) {
            resetFrontAndRear();
            return;
        }
        decrementRear();
    }

    private void setFrontIndexAfterDeletion() {
        if (size == 1) {
            resetFrontAndRear();
            return;
        }
        decrementFront();
    }

    private void queueStatus() {
        System.out.println("Front index: " + front);
        System.out.println("Rear index: " + rear);
        System.out.println("Front element: " + retrieveElementAtIndex(front));
        System.out.println("Rear element: " + retrieveElementAtIndex(rear));
        System.out.println("Size of deque: " + size);
        System.out.println();
        displayQueue();
        System.out.println("#########################");
    }

    public void insertAtFront(Integer elementToEnqueue) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        setFrontIndexForInsertion();
        setElementAtIndex(front, elementToEnqueue);
        System.out.println("Enqueued at front " + front);
        incrementSize();
        queueStatus();
    }

    public void insertAtBack(Integer elementToEnqueue) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        setRearIndexForInsertion();
        setElementAtIndex(rear, elementToEnqueue);
        System.out.println("Enqueued at rear " + rear);
        incrementSize();
        queueStatus();
    }

    public void deleteFromFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Integer elementToDelete = retrieveElementAtIndex(front);
        setElementAtIndex(front, null);
        System.out.println("The element " + elementToDelete + " was deleted at " + front);
        setFrontIndexAfterDeletion();
        decrementSize();
        queueStatus();
    }

    public void deleteFromRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Integer elementToDelete = retrieveElementAtIndex(rear);
        setElementAtIndex(rear, null); // For garbage collection
        System.out.println("The element " + elementToDelete + " was deleted at " + rear);
        setRearIndexAfterDeletion();
        decrementSize();
        queueStatus();
    }

    public static void main(String args[]) {
        Deque dq = new Deque(5);
        dq.insertAtBack(5);
        dq.insertAtBack(10);
        dq.deleteFromRear();
        dq.insertAtFront(15);
        dq.deleteFromFront();
    }

}
