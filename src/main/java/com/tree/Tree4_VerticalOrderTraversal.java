package com.tree;

import java.util.*;

public class Tree4_VerticalOrderTraversal {
    //Function to find the vertical order traversal of Binary Tree.
    public ArrayList<Integer> printVerticalOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrderUtil(map, root, 0);
        for (ArrayList<Integer> val : map.values()) {
            ans.addAll(val);
        }
        return ans;
    }

    public void verticalOrderUtil(TreeMap<Integer, ArrayList<Integer>> map, Node root, int height) {
        if (root == null)
            return;
        ArrayList<Integer> list = map.get(height);
        if (list == null) {
            list = new ArrayList<>();
            list.add(root.data);

        } else {
            list.add(root.data);
        }
        map.put(height, list);
        verticalOrderUtil(map, root.left, height - 1);
        verticalOrderUtil(map, root.right, height + 1);

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Tree1_BSTOperations tree = new Tree1_BSTOperations();
        tree.insertion(root, 4);
        tree.insertion(root, 7);
        tree.insertion(root, 1);
        tree.insertion(root, 15);
        Tree4_VerticalOrderTraversal verticalOrder = new Tree4_VerticalOrderTraversal();
        System.out.println(verticalOrder.printVerticalOrder(root));
    }
}
