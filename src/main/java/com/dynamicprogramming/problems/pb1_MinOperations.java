package com.dynamicprogramming.problems;

/*
* Given a number N. Find the minimum number of operations required to reach N starting from 0.
*  You have 2 operations available:
    Double the number
    Add one to the number

* */
public class pb1_MinOperations {
    private static int minOperation(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            if ((i + 1) <= n && (arr[i + 1] == 0 || arr[i + 1] > arr[i] + 1)) {
                arr[i + 1] = arr[i] + 1;
            }
            if ((i * 2) <= n && (arr[i * 2] == 0 || arr[i * 2] > arr[i] + 1)) {
                arr[i * 2] = arr[i] + 1;
            }
        }
        for (int i = 0; i <= n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        return arr[n-1];
    }
    public int minOperations(int n) {
        int count = 0;
        while (n != 0) {
            // if n is even then it will be good to
            // reach n from n/2 by multiplying it by 2.
            if (n % 2 == 0)
                n /= 2;
                // if n is odd then we can reach n from n-- only.
            else
                n--;

            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minOperation(5));
    }
}
