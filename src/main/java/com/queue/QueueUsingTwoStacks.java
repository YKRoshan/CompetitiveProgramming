package com.queue;

import java.util.Stack;

class QueueUsing2S {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void push(int x) {
        // Your code here
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
    }

    //Function to pop an element from queue by using 2 stacks.
    int pop() {
        // Your code here
        if (s2.empty())
            return -1;
        return s2.pop();
    }
}

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        QueueUsing2S queue = new QueueUsing2S();
        queue.push(5);
        queue.push(8);
        queue.push(7);
        queue.push(4);
        queue.push(1);
        queue.push(9);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}