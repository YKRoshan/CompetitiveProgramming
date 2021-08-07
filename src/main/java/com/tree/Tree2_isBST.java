package com.tree;

public class Tree2_isBST {

    /* Returns true if a binary tree is a binary search tree */
    boolean isBST(Node node) {
        if (node == null)
            return true;

        /* false if the max of the left is > than us */
        if (node.left != null && maxValue(node.left) > node.data)
            return false;

        /* false if the min of the right is <= than us */
        if (node.right != null && minValue(node.right) < node.data)
            return false;

        /* false if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* passing all that, it's a BST */
        return true;
    }

    private int maxValue(Node root) {
        return root.left == null ? root.data : maxValue(root.left);
    }

    private int minValue(Node root) {
        return root.right == null ? root.data : minValue(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Tree1_BSTOperations tree = new Tree1_BSTOperations();
        System.out.println(tree.insertion(root, 4).data);
        System.out.println(tree.insertion(root, 7).data);
        System.out.println(tree.insertion(root, 1).data);
        System.out.println(tree.insertion(root, 15).data);
        Tree2_isBST isBST=new Tree2_isBST();
        System.out.println(isBST.isBST(root));
    }
}
