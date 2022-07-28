package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int k) {
            key = k;
            left = null;
            right = null;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getKey() {
            return key;
        }
    }

    private Queue<Node> queue;
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void inOrder(Node temp) {
        if (temp == null)
            return;

        inOrder(temp.left);
        System.out.print(temp.key + " ");
        inOrder(temp.right);
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            queue.add(temp.left);
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            queue.add(temp.right);
        }
    }

    public void delete(int key) {
        if (root == null) {
            return;
        }
        if (root.getKey() == key) {
            Node right = root.getRight();
            right.left = root.getLeft();
            root = null;
            root = right;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node keyElement = null;
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.remove();

            if (temp.getKey() == key) {
                keyElement = temp;
            }
            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }
        }

        if (keyElement != null) {
            int k = temp.getKey();
            temp = null;
            keyElement.key = k;
        }

    }

    boolean isFoldable(Node node) {
        boolean res;

        /* base case */
        if (node == null)
            return true;

        /* convert left subtree to its mirror */
        mirror(node.left);

        /*
         * Compare the structures of the right subtree and mirrored
         * left subtree
         */
        res = isStructSame(node.left, node.right);

        /* Get the original tree back */
        mirror(node.left);

        return res;
    }

    boolean isStructSame(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a != null && b != null
                && isStructSame(a.left, b.left)
                && isStructSame(a.right, b.right))
            return true;

        return false;
    }

    void mirror(Node node) {
        if (node == null)
            return;
        else {
            Node temp;

            /* do the subtrees */
            mirror(node.left);
            mirror(node.right);

            /* swap the pointers in this node */
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.inOrder(bt.getRoot());
    }
}
