package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree5_LeftViewOfATree {
	private static void printLeftView(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				if (i == 0)
					System.out.println(queue.peek().data);
				Node node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		Tree1_BSTOperations tree = new Tree1_BSTOperations();
		tree.insertion(root, 4);
		tree.insertion(root, 7);
		tree.insertion(root, 1);
		tree.insertion(root, 15);
		printLeftView(root);
	}
}
