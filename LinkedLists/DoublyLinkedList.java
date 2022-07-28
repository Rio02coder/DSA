package LinkedLists;

public class DoublyLinkedList<E> {
    private DoubleNode<E> header; // Sentinel Node
    private DoubleNode<E> trailer; // Sentinel Node
    private int size;

    public DoublyLinkedList() {
        size = 0;
        header = new DoubleNode<>(null, null, null);
        trailer = new DoubleNode<>(null, header, null);
        header.setNext(trailer);
    }

    public int getSize() {
        return size;
    }

    private void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    private DoubleNode<E> getHead() {
        return header.getNext();
    }

    private DoubleNode<E> getTail() {
        return trailer.getPrev();
    }

    public E front() {
        return getHead().getElement();
    }

    public E rear() {
        return getTail().getElement();
    }

    private void makeHead(DoubleNode<E> newHead) {
        getHead().setPrev(newHead);
        header.setNext(newHead);
    }

    private void makeTail(DoubleNode<E> newTail) {
        getTail().setNext(newTail);
        trailer.setPrev(newTail);
    }

    private E detachNode(DoubleNode<E> node) {
        node.setNext(null);
        node.setPrev(null);
        return node.getElement();
    }

    public void pushAtBeginning(E element) {
        DoubleNode<E> newNode = new DoubleNode<>(element, header, getHead());
        makeHead(newNode);
        incrementSize();
    }

    public void pushAtEnd(E element) {
        DoubleNode<E> newNode = new DoubleNode<>(element, getTail(), trailer);
        makeTail(newNode);
        incrementSize();
    }

    private E deleteNode(DoubleNode<E> node) {
        DoubleNode<E> nextNode = node.getNext();
        node.getPrev().setNext(nextNode);
        nextNode.setPrev(node.getPrev());
        return detachNode(node);
    }

    public E popAtBeginning() {
        if (size == 0) {
            return null;
        }
        decrementSize();
        return deleteNode(getHead());
    }

    public E popAtEnd() {
        if (size == 0) {
            return null;
        }
        decrementSize();
        return deleteNode(getTail());
    }
}
