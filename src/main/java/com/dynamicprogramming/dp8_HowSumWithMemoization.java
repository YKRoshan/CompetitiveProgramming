package com.dynamicprogramming;

import java.util.*;

public class dp8_HowSumWithMemoization {
    /*
     * Write a function `howSum(targetSum, numbers)` that takes in targetSum and an array as arguments
     * The function should return a list of numbers if it is possible to generate the
     * targetSum using numbers from the array else it should return null.
     * You may use an element of the array as many times as needed.
     * You may assume that all input numbers are +ve.
     * */

    public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
        return howSumWithMemo(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> howSumWithMemo(int targetSum, List<Integer> numbers,
                                                HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum < 0) {
            return null;
        }
        if (targetSum == 0) {
            return (new ArrayList<>());
        }
        for (Integer value : numbers) {
            List<Integer> result = howSumWithMemo(targetSum - value, numbers, memo);
            if (result != null) {
                result.add(0, value);
                memo.put(targetSum, result);
                return result;
            }
        }
        memo.put(targetSum, null);
        return null;
    }


    public static void main(String[] args) {
        System.out.println(howSum(7, new ArrayList(Arrays.asList(2, 3))));
        System.out.println(howSum(7, new ArrayList(Arrays.asList(5, 4, 3, 7))));
        System.out.println(howSum(7, new ArrayList(Arrays.asList(2, 4))));
        System.out.println(howSum(8, new ArrayList(Arrays.asList(2, 3, 5))));
        System.out.println(howSum(300, new ArrayList(Arrays.asList(7, 14))));//It will take lots of time to execute
    }
}
