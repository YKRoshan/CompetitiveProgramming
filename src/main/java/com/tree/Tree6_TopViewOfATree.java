package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree6_TopViewOfATree {

	//Returning topView using BFS approach
	static ArrayList<Integer> topView(Node root) {
		//TreeMap is used because we wanted to print the data in sorted order
		// (sorting is based on horizontal distance)
		TreeMap<Integer, Integer> map = new TreeMap<>();
		//Queue contains Node and its horizontal distance from root node
		Queue<Map<Node, Integer>> queue = new LinkedList<>();
		Map<Node, Integer> map1 = new HashMap<>();
		map1.put(root, 0);
		queue.add(map1);
		while (!queue.isEmpty()) {
			Map<Node, Integer> val = queue.poll();
			Node node = val.keySet().iterator().next();
			int d = val.get(node);
			if (!map.containsKey(d)) {
				map.put(d, node.data);
			}
			if (node.left != null) {
				Map<Node, Integer> t1 = new HashMap<>();
				t1.put(node.left, d - 1);
				queue.add(t1);
			}
			if (node.right != null) {
				Map<Node, Integer> t2 = new HashMap<>();
				t2.put(node.right, d + 1);
				queue.add(t2);
			}
		}
		//Returning values from leftmost to rightmost
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		Tree1_BSTOperations tree = new Tree1_BSTOperations();
		tree.insertion(root, 4);
		tree.insertion(root, 7);
		tree.insertion(root, 1);
		tree.insertion(root, 15);
		System.out.println(topView(root));
	}
}
