package LinkedLists;

public class DoubleNode<E> {
    private E element;
    private DoubleNode<E> next;
    private DoubleNode<E> prev;

    public DoubleNode(E element, DoubleNode<E> prev, DoubleNode<E> next) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode<E> getPrev() {
        return this.prev;
    }

    public DoubleNode<E> getNext() {
        return this.next;
    }

    public E getElement() {
        return this.element;
    }

    public void setNext(DoubleNode<E> nextNode) {
        this.next = nextNode;
    }

    public void setPrev(DoubleNode<E> prevNode) {
        this.prev = prevNode;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
