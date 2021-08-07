package com.dynamicprogramming;

public class dp17_FibonacciUsingTabulation {
    public static long fib(int n) {
        long[] table = new long[n + 1];
        for (int i = 0; i < table.length; i++) {
            table[i] = 0;
        }
        table[1] = 1;
        for (int i = 0; i < table.length - 1; i++) {
            table[i + 1] += table[i];
            if ((i + 2) < table.length)
                table[i + 2] += table[i];
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(8));
        System.out.println(fib(10));
        System.out.println(fib(50));
    }
}
