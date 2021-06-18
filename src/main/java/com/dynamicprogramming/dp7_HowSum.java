package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class dp7_HowSum {
    /*
     * Write a function `howSum(targetSum, numbers)` that takes in targetSum and an array as arguments
     * The function should return a list of numbers if it is possible to generate the
     * targetSum using numbers from the array else it should return null.
     * You may use an element of the array as many times as needed.
     * You may assume that all input numbers are +ve.
     * */

    public static boolean howSum(int n, int[] numbers) {
        for (int i : numbers) {
            if (n - i == 0){
                System.out.println(i);
                return true;
            }

        }
        boolean result = false;
        for (int i : numbers) {
            if (n - i > 0){
                result = result || howSum(n - i, numbers);
                if (result==true){
                    System.out.println(i);
                    return true;
                }

            }

        }
        return result;
    }

    public List<Integer> naiveHowSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return (new ArrayList<>()); }
        for (Integer value : numbers) {
            List<Integer> result = naiveHowSum(targetSum - value, numbers);
            if (result != null) {
                result.add(0, value);
                return result;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{4, 3, 6}));
        System.out.println(howSum(2, new int[]{4, 3, 6, 7}));
        System.out.println(howSum(9, new int[]{7, 5, 8}));
        System.out.println(howSum(5, new int[]{2, 3, 6}));
        System.out.println(howSum(3000, new int[]{7, 14}));//It will take lots of time to execute
    }
}
