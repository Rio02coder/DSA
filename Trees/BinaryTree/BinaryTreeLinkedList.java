package Trees.BinaryTree;

public class BinaryTreeLinkedList<E> {
    private Node<E> root;
    private int size;

    public BinaryTreeLinkedList(E rootElement) {
        this.root = new Node<E>(null, null, null, rootElement);
        size = 1;
    }

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private Node<E> createNode(E element, Node<E> parent) {
        return new Node<E>(parent, null, null, element);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Node<E> root() {
        return root;
    }

    /**
     * This method checks if the node is fit for performing an operation
     * If yes, it returns nothing and if no then it throws an
     * illegalArgumentException
     * 
     * @param position the node we are checking
     */
    private void checkOperationIsValidOnNode(Node<E> position) {
        if (position == null)
            throw new IllegalArgumentException("The node does not exist");
    }

    /**
     * This method throws an exception if the position already exists and otherwise
     * returns nothing
     * 
     * @param position The node we would like to check
     */
    private void checkIfNodeAlreadyExists(Node<E> position) {
        if (position != null)
            throw new IllegalArgumentException("The node already exists");
    }

    private void isTreeSafe(BinaryTreeLinkedList<E> tree) throws IllegalArgumentException {
        if (tree == null)
            throw new IllegalArgumentException("Tree is null");
    }

    public boolean isExternal(Node<E> position) throws IllegalArgumentException {
        checkOperationIsValidOnNode(position);
        return position.numberOfChildren() == 0;
    }

    private void isSafeForAddition(Node<E> position, Node<E> childToCheck) throws IllegalArgumentException {
        checkOperationIsValidOnNode(position);
        checkIfNodeAlreadyExists(childToCheck);
    }

    public Node<E> parent(Node<E> position) throws IllegalArgumentException {
        checkOperationIsValidOnNode(position);
        return position.getParent();
    }

    public Node<E> leftChild(Node<E> position) throws IllegalArgumentException {
        checkOperationIsValidOnNode(position);
        return position.getLeftChild();
    }

    public Node<E> right(Node<E> position) throws IllegalArgumentException {
        checkOperationIsValidOnNode(position);
        return position.getRightChild();
    }

    public E element(Node<E> position) throws IllegalArgumentException {
        checkOperationIsValidOnNode(position);
        return position.getElement();
    }

    public void setElement(Node<E> position, E element) throws IllegalArgumentException {
        checkOperationIsValidOnNode(position);
        position.setElement(element);
    }

    private Node<E> getTheOnlyChild(Node<E> position) throws IllegalArgumentException {
        if (position.getLeftChild() != null && position.getRightChild() != null)
            throw new IllegalArgumentException();
        return position.getLeftChild() == null ? position.getRightChild() : position.getLeftChild();
    }

    public void addLeft(Node<E> position, E element) throws IllegalArgumentException {
        isSafeForAddition(position, position.getLeftChild());
        position.setLeftChild(createNode(element, position));
        incrementSize();
    }

    public void addRight(Node<E> position, E element) throws IllegalArgumentException {
        isSafeForAddition(position, position.getRightChild());
        position.setRightChild(createNode(element, position));
        incrementSize();
    }

    private void nullifyElement(Node<E> position) {
        position.setLeftChild(null);
        position.setRightChild(null);
        position.setParent(null);
        position.setElement(null);
        position = null;
    }

    private void replaceChildOfGrandparent(Node<E> grandParent, Node<E> child, Node<E> grandChild) {
        if (child.equals(grandParent.getLeftChild())) {
            grandParent.setLeftChild(grandChild);
        } else {
            grandParent.setRightChild(grandChild);
        }
        grandChild.setParent(grandParent);
    }

    public void addRoot(E element) throws IllegalCallerException {
        if (isEmpty()) {
            root = createNode(element, null);
            incrementSize();
            return;
        }
        throw new IllegalCallerException();
    }

    public void deleteNode(Node<E> position) throws IllegalArgumentException {
        if (isExternal(position)) {
            throw new IllegalArgumentException();
        }

        Node<E> grandParent = position.getParent();
        Node<E> child = getTheOnlyChild(position); // This line can throw the exception if more than one child exits

        if (grandParent == null) { // Deleting child of root
            root = child;
            child.setParent(null);
        } else {
            replaceChildOfGrandparent(grandParent, position, child);
        }

        nullifyElement(position);

        decrementSize();
    }

    public void attachTrees(Node<E> position, BinaryTreeLinkedList<E> leftTree, BinaryTreeLinkedList<E> rightTree)
            throws IllegalArgumentException {
        if (!isExternal(position)) {
            throw new IllegalArgumentException();
        }

        isTreeSafe(leftTree);
        isTreeSafe(rightTree);

        // Process the left subtree
        position.setLeftChild(leftTree.root);
        leftTree.root.setParent(position);

        // Process the right subtree
        position.setRightChild(rightTree.root);
        rightTree.root.setParent(position);

        // Update size
        setSize(this.size + leftTree.size + rightTree.size);
    }

    // Tree traversals
    public void inOrderTraversal(Node<E> nodeToStartFrom) {
        if (nodeToStartFrom == null) {
            return;
        }
        inOrderTraversal(nodeToStartFrom.getLeftChild());
        System.out.print(" " + nodeToStartFrom.getElement() + " ");
        inOrderTraversal(nodeToStartFrom.getRightChild());
    }

    public void preOrderTraversal(Node<E> nodeToStartFrom) {
        if (nodeToStartFrom == null) {
            return;
        }
        System.out.print(" " + nodeToStartFrom.getElement() + " ");
        preOrderTraversal(nodeToStartFrom.getLeftChild());
        preOrderTraversal(nodeToStartFrom.getRightChild());
    }

    public void postOrderTraversal(Node<E> nodeToStartFrom) {
        if (nodeToStartFrom == null) {
            return;
        }
        preOrderTraversal(nodeToStartFrom.getLeftChild());
        preOrderTraversal(nodeToStartFrom.getRightChild());
        System.out.print(" " + nodeToStartFrom.getElement() + " ");
    }

    public static void main(String[] args) {
        BinaryTreeLinkedList<Integer> binaryTreeLinkedList = new BinaryTreeLinkedList<Integer>(0);
        binaryTreeLinkedList.addLeft(binaryTreeLinkedList.root(), 1);

        binaryTreeLinkedList.deleteNode(binaryTreeLinkedList.root());

        System.out.println("In order traversal");
        binaryTreeLinkedList.inOrderTraversal(binaryTreeLinkedList.root());

        System.out.println(" ");

        System.out.println("Pre order traversal");
        binaryTreeLinkedList.preOrderTraversal(binaryTreeLinkedList.root());

        System.out.println(" ");

        System.out.println("Post order traversal");
        binaryTreeLinkedList.postOrderTraversal(binaryTreeLinkedList.root());
    }
}