package com.tree;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int v) {
        left = right = null;
        data = v;
    }
}

public class Tree1_BSTOperations {
    public Node insertion(Node root, int v) {
        if (root == null) {
            return new Node(v);
        }
        if (v < root.data) {
            root.left = insertion(root.left, v);
        } else {
            root.right = insertion(root.right, v);
        }
        return root;
    }

    public boolean searching(Node root, int v) {
        if (root == null)
            return false;
        if (root.data == v)
            return true;
        else if (v < root.data)
            return searching(root.left, v);
        else
            return searching(root.right, v);
    }

    public Node deletion(Node root, int v) {
        if (root == null)
            return null;
        if (root.data == v) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
/*                int temp = root.data;
                root.data = root.right.data;
                root.right.data = temp;*/
                Node min = findMin(root.left);
                root.data = min.data;
                root.left = deletion(root.left, min.data);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else
                return root.right;
        } else if (v < root.data) {
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

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.peek() != null) {
            // number of nodes at current level
            int size = q.size();
            // Traverse all nodes of current level
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (i == 0)
                    ans.add(node.data);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return ans;
    }

    static void printBottomViewUtil(Node root, int curr, int hd,
                                    TreeMap<Integer, int[]> m)
    {

        // Base case
        if (root == null)
            return;
        if (!m.containsKey(hd))
        {
            m.put(hd, new int[]{ root.data, curr });
        }
        else
        {
            int[] p = m.get(hd);
            if (p[1] <= curr)
            {
                p[1] = curr;
                p[0] = root.data;
            }
            m.put(hd, p);
        }

        printBottomViewUtil(root.left, curr + 1,
            hd - 1, m);

        printBottomViewUtil(root.right, curr + 1,
            hd + 1, m);
    }

    static void printBottomView(Node root)
    {

        // Map to store Horizontal Distance,
        // Height and Data.
        TreeMap<Integer, int[]> m = new TreeMap<>();

        printBottomViewUtil(root, 0, 0, m);

        // Prints the values stored by printBottomViewUtil()
        for(int val[] : m.values())
        {
            System.out.print(val[0] + " ");
        }
    }

    private Node findMin(Node root) {
        return root.left == null ? root : findMin(root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Tree1_BSTOperations tree = new Tree1_BSTOperations();
   /*     System.out.println(tree.insertion(root, 4).data);
        System.out.println(tree.insertion(root, 7).data);
        System.out.println(tree.insertion(root, 1).data);
        System.out.println(tree.insertion(root, 15).data);*/

       tree.printBottomView(root);

/*        System.out.println(tree.searching(root, 7));
        System.out.println(tree.searching(root, 1));
        System.out.println(tree.searching(root, 8));

        System.out.println(tree.deletion(root, 7).data);
        System.out.println(tree.searching(root, 7));*/
    }
}
