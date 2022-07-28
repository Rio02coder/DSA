package LinkedLists;

public class SinglyLinkedList {
    private Node<Integer> head;
    private Node<Integer> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<Integer> getHead() {
        return head;
    }

    public Node<Integer> getTail() {
        return tail;
    }

    private Node<Integer> getNewNode(Integer elementToAdd) {
        return new Node<Integer>(elementToAdd, null);
    }

    private void setHead(Node<Integer> node) {
        head = node;
    }

    private void setTail(Node<Integer> node) {
        tail = node;
    }

    private void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    public void addAtBeginning(Integer elementToAdd) {
        Node<Integer> newNode = getNewNode(elementToAdd);
        newNode.setNextNode(head);
        setHead(newNode);

        if (size == 0) {
            setTail(head);
        }

        incrementSize();
    }

    public Integer removeAtBeginning() {

        if (isEmpty()) {
            return null;
        }

        Node<Integer> nodeToRemove = head;
        Integer elementToRemove = head.getElement();

        setHead(head.getNextNode());

        if (size == 1) {
            tail = head;
        }

        nodeToRemove.setNextNode(null);

        decrementSize();

        return elementToRemove;
    }

    public void addAtEnd(Integer elementToAdd) {

        Node<Integer> newNode = getNewNode(elementToAdd);

        setTail(newNode);

        if (isEmpty()) {
            setHead(tail);
        }

        else {
            tail.setNextNode(newNode);
        }

        incrementSize();

    }

    public SinglyLinkedList addSinglyLinkedList(SinglyLinkedList toBeAddedList) {
        if (isEmpty()) {
            return toBeAddedList;
        }

        if (toBeAddedList.isEmpty()) {
            return this;
        }

        this.tail.setNextNode(toBeAddedList.head);

        setTail(toBeAddedList.getTail());

        return this;
    }

    private Node<Integer> getPreviousNode(Node<Integer> node) {
        if (isEmpty()) {
            return null;
        }

        Node<Integer> nodeToReturn = head;

        while (nodeToReturn.getNextNode() != node || nodeToReturn.getNextNode() != null) {
            nodeToReturn = nodeToReturn.getNextNode();
        }

        return nodeToReturn != head ? null : nodeToReturn;
    }

    private void swapHeadAndTail() {
        Node<Integer> intermediaryNode = tail;
        tail = head;
        head = intermediaryNode;
    }

    // Reverse a linked list
    public void reverseList() {
        if (isEmpty() || size == 1) {
            return;
        }
        if (size == 2) {
            swapHeadAndTail();
        }
        Node<Integer> previousNode = head;
        Node<Integer> currentNode = head.getNextNode();
        head.setNextNode(null); // Setting next node of the head to null
        while (currentNode != null) {
            Node<Integer> temporaryNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = temporaryNode;
        }
        swapHeadAndTail();
    }

    // Swapping two nodes of a linked list
    // Where the nodes have been given in the order of appearance
    public void swapTwoNodes(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        Node<Integer> previousNode1 = getPreviousNode(node1);
        Node<Integer> previousNode2 = getPreviousNode(node2);

        if (previousNode1 == previousNode2) {
            return;
        }
        node1.setNextNode(node2.getNextNode());
        node2.setNextNode(node1.getNextNode());

        if (node1.getNextNode() == null) {
            setTail(node1);
        }

        if (previousNode1 == null) {
            setHead(node2);
        }
    }

    // Merging a list at alternate positions
    public void mergeTwoListsAtAlternatePositions(SinglyLinkedList listToMerge) {
        Node<Integer> node = this.getHead();

        while (node != null) {
            Integer element = listToMerge.removeAtBeginning();
            if (element == null) {
                break;
            }
            Node<Integer> newNode = getNewNode(element);
            newNode.setNextNode(node.getNextNode());
            if (node.getNextNode() == null) {
                tail = newNode;
            }
            node.setNextNode(newNode);
            node = newNode.getNextNode();
        }

    }

    public void printList() {
        Node<Integer> node = head;
        while (node != null) {
            System.out.print(node.getElement() + " -> ");
            node = node.getNextNode();
        }
    }
}
