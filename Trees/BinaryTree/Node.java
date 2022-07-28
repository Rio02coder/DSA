package Trees.BinaryTree;

public class Node<E> {
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;
    private E element;

    public Node(Node<E> parent, Node<E> left, Node<E> right, E element) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.element = element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public Node<E> getLeftChild() {
        return left;
    }

    public Node<E> getRightChild() {
        return right;
    }

    public E getElement() {
        return element;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public void setLeftChild(Node<E> left) {
        this.left = left;
    }

    public void setRightChild(Node<E> right) {
        this.right = right;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public int numberOfChildren() {
        int numberOfChildren = 0;
        if (this.left != null) {
            numberOfChildren++;
        }
        if (this.right != null) {
            numberOfChildren++;
        }
        return numberOfChildren;
    }

}
