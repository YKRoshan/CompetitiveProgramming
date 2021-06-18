package com.dynamicprogramming;

/*
 * Write a function `howSum(targetSum, numbers)` that takes in targetSum and an array as arguments
 * The function should return a boolean indicating whether or not it is possible to generate the
 * targetSum using numbers from the array.
 * You may use an element of the array as many times as needed.
 * You may assume that all input numbers are +ve.
 * */
public class dp5_CanSum {

    public static boolean canSum(int n, int[] numbers) {
        for (int i : numbers) {
            if (n - i == 0)
                return true;
        }
        boolean result = false;
        for (int i : numbers) {
            if (n - i > 0)
                result = result || canSum(n - i, numbers);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{4, 3, 6, 7}));
        System.out.println(canSum(2, new int[]{4, 3, 6, 7}));
        System.out.println(canSum(9, new int[]{7, 5, 8}));
        System.out.println(canSum(5, new int[]{2, 3, 6}));
        System.out.println(canSum(3000, new int[]{7,14}));
    }
}
