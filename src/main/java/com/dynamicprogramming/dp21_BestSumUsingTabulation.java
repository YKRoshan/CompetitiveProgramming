package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp21_BestSumUsingTabulation {
    private static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
        List<List<Integer>> tabulation = new ArrayList<>();
        tabulation.add(new ArrayList<>());
        for (int i = 0; i < targetSum; i++) {
            tabulation.add(null);
        }
        for (int i = 0; i <= targetSum; i++) {
            for (Integer number : numbers) {
                int index = i + number;
                if (index > targetSum || tabulation.get(i) == null) {
                    continue;
                }
                List<Integer> list = new ArrayList<>(tabulation.get(i));
                list.add(0, number);
                if (tabulation.get(index) == null || tabulation.get(index).size() > list.size()) {
                    tabulation.set(index, list);
                }
            }
        }
        return tabulation.get(targetSum);
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new ArrayList(Arrays.asList(2, 3))));
        System.out.println(bestSum(7, new ArrayList(Arrays.asList(5, 4, 3, 7))));
        System.out.println(bestSum(7, new ArrayList(Arrays.asList(2, 4))));
        System.out.println(bestSum(8, new ArrayList(Arrays.asList(2, 3, 5))));
        System.out.println(bestSum(300, new ArrayList(Arrays.asList(7, 14))));//It will take lots of time to execute
    }
}
