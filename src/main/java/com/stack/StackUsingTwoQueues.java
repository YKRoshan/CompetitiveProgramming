package com.stack;

    import java.util.LinkedList;
    import java.util.Queue;

class StackUsing2Q {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    //Function to push an element into stack using two queues.
    void push(int a) {
        // Your code here
        while (q1.peek() != null) {
            q2.add(q1.remove());
        }
        q1.add(a);
        while (q2.peek() != null) {
            q1.add(q2.remove());
        }
    }

    //Function to pop an element from stack using two queues.
    int pop() {
        // Your code here
        if (q1.peek() == null)
            return -1;
        return q1.remove();
    }
}

public class StackUsingTwoQueues {
    public static void main(String args[]) {
        StackUsing2Q stack = new StackUsing2Q();
        stack.push(1);
        stack.push(5);
        stack.push(7);
        stack.push(6);
        stack.push(10);
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}