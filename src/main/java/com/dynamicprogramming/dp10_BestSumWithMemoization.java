package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class dp10_BestSumWithMemoization {
    public static List<Integer> bestSumMemo(int targetSum, List<Integer> numbers) {
        return bestSumWithMemoization(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> bestSumWithMemoization(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum < 0) {
            return null;
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        List<Integer> shortest = null;
        for (Integer value : numbers) {
            List<Integer> combination = bestSumWithMemoization(targetSum - value, numbers, memo);
            if (combination != null) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                list.addAll(combination);
                if (shortest == null || shortest.size() > list.size()) {
                    shortest = list;
                }
            }
        }
        memo.put(targetSum, shortest);
        return shortest;
    }

    public static void main(String[] args) {
        System.out.println(bestSumMemo(7, new ArrayList(Arrays.asList(2, 3))));
        System.out.println(bestSumMemo(7, new ArrayList(Arrays.asList(5, 4, 3, 7))));
        System.out.println(bestSumMemo(7, new ArrayList(Arrays.asList(2, 4))));
        System.out.println(bestSumMemo(8, new ArrayList(Arrays.asList(2, 3, 5))));
        System.out.println(bestSumMemo(100, new ArrayList(Arrays.asList(1,2,5,25))));//It will take lots of time to
        // execute
    }
}
