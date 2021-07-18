package com.queue;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int i;
    int j;
    int value;

    Node(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }
}

public class RottenOranges {
    //Function to find minimum time required to rot all oranges.
    int time = 0;

    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            Node node = q.remove();
            if (node.i > 0 && grid[node.i - 1][node.j] == 1) {
                grid[node.i - 1][node.j] = 2;
                q.add(new Node(node.i - 1, node.j, node.value + 1));
            }
            if ((node.i + 1) < grid.length && grid[node.i + 1][node.j] == 1) {
                grid[node.i + 1][node.j] = 2;
                q.add(new Node(node.i + 1, node.j, node.value + 1));
            }
            if (node.j > 0 && grid[node.i][node.j - 1] == 1) {
                grid[node.i][node.j - 1] = 2;
                q.add(new Node(node.i, node.j - 1, node.value + 1));
            }
            if ((node.j + 1) < grid[0].length && grid[node.i][node.j + 1] == 1) {
                grid[node.i][node.j + 1] = 2;
                q.add(new Node(node.i, node.j + 1, node.value + 1));
            }
            time = node.value > time ? node.value : time;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] oranges = new int[3][3];
        //new int[][]{{0, 1, 0}, {2, 1, 0}, {2, 1, 2}};
        oranges[0] = new int[]{0, 1, 0};
        oranges[1] = new int[]{2, 1, 0};
        oranges[2] = new int[]{2, 1, 2};
        System.out.println(rottenOranges.orangesRotting(oranges));
    }
}