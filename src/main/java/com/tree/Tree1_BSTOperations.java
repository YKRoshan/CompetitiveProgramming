package com.tree;

class Node {
    Node left;
    Node right;
    int value;

    Node(int v) {
        left = right = null;
        value = v;
    }
}

public class Tree1_BSTOperations {
    public Node insertion(Node root, int v) {
        if (root == null) {
            return new Node(v);
        }
        if (v < root.value) {
            root.left = insertion(root.left, v);
        } else {
            root.right = insertion(root.right, v);
        }
        return root;
    }

    public boolean searching(Node root, int v) {
        if (root == null)
            return false;
        if (root.value == v)
            return true;
        else if (v < root.value)
            return searching(root.left, v);
        else
            return searching(root.right, v);
    }

    public Node deletion(Node root, int v) {
        if (root == null)
            return null;
        if (root.value == v) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
/*                int temp = root.value;
                root.value = root.right.value;
                root.right.value = temp;*/
                Node min = findMin(root.left);
                root.value = min.value;
                root.left = deletion(root.left, min.value);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else
                return root.right;
        } else if (v < root.value) {
            root.left = deletion(root.left, v);
            return root;
        } else {
            root.right = deletion(root.right, v);
            return root;
        }
    }

    /* Returns true if a binary tree is a binary search tree */
    boolean isBST(Node node) {
        if (node == null)
            return true;

        /* false if the max of the left is > than us */
        if (node.left != null && maxValue(node.left) > node.value)
            return false;

        /* false if the min of the right is <= than us */
        if (node.right != null && minValue(node.right) < node.value)
            return false;

        /* false if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* passing all that, it's a BST */
        return true;
    }

    private int maxValue(Node root) {
        return root.left == null ? root.value : maxValue(root.left);
    }

    private int minValue(Node root) {
        return root.right == null ? root.value : minValue(root.right);
    }

// This code is contributed by shubhamsingh10


    private Node findMin(Node root) {
        return root.left == null ? root : findMin(root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Tree1_BSTOperations tree = new Tree1_BSTOperations();
        System.out.println(tree.insertion(root, 4).value);
        System.out.println(tree.insertion(root, 7).value);
        System.out.println(tree.insertion(root, 1).value);
        System.out.println(tree.insertion(root, 15).value);

        System.out.println(tree.searching(root, 7));
        System.out.println(tree.searching(root, 1));
        System.out.println(tree.searching(root, 8));

        System.out.println(tree.deletion(root, 7).value);
        System.out.println(tree.searching(root, 7));
    }
}
