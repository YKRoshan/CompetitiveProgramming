package com.dynamicprogramming;

import java.util.*;

public class dp9_BestSum {

    private static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        List<Integer> shortest = null;
        for (int value : numbers) {
            List<Integer> combination = bestSum(targetSum - value, numbers);
            if (combination != null) {
                combination.add(value);
                if (shortest == null || shortest.size() > combination.size()) {
                    shortest = combination;
                }
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new ArrayList(Arrays.asList(2, 3))));
        System.out.println(bestSum(7, new ArrayList(Arrays.asList(5, 4, 3, 7))));
        System.out.println(bestSum(7, new ArrayList(Arrays.asList(2, 4))));
        System.out.println(bestSum(8, new ArrayList(Arrays.asList(2, 3, 5))));
        System.out.println(bestSum(300, new ArrayList(Arrays.asList(7, 14))));//It will take lots of time to execute
    }
}
