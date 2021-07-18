package com.stack;

import java.util.*;
import java.lang.*;

class Stack1_ParenthesisChecker {
    //Function to check if brackets are balanced or not.
    static boolean isBalanced(String x) {
        // add your code here
        Stack<Character> stack1 = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            stack1.push(x.charAt(i));
        }
        Stack<Character> stack2 = new Stack<>();
        while (!stack1.empty()) {
            char top = stack1.pop();
            if (!stack2.empty() && (top == '[' && stack2.peek() == ']' || top == '{' && stack2.peek() == '}' ||
                top == '(' && stack2.peek() == ')')) {
                stack2.pop();
            } else
                stack2.push(top);
        }
        return stack2.empty() ? true : false;
    }
    public static void main(String []args){
        System.out.println(isBalanced("{}[(())]"));
    }
}
