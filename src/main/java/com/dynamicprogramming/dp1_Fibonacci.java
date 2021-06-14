package com.dynamicprogramming;

public class dp1_Fibonacci {
    public static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(8));
        System.out.println(fib(10));//
        System.out.println(fib(50));//It will take lots of time to execute
    }
}
