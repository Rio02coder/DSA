package LinkedLists;

public class Node<E> {
    private E element;
    private Node<E> nextNode;

    public Node(E element, Node<E> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNode(E newElement) {
        this.element = newElement;
    }

    public void setNextNode(Node<E> newNextNode) {
        this.nextNode = newNextNode;
    }
}
