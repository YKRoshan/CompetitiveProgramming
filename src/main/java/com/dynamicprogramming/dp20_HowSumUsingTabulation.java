package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp20_HowSumUsingTabulation {
    public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
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
                if (index == targetSum) {
                    return list;
                }
                tabulation.set(index, list);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(howSum(7, Arrays.asList(4, 3, 6)));
        System.out.println(howSum(2, Arrays.asList(4, 3, 6, 7)));
        System.out.println(howSum(9, Arrays.asList(7, 5, 8)));
        System.out.println(howSum(5, Arrays.asList(2, 3, 6)));
        System.out.println(howSum(300, Arrays.asList(7, 14)));

    }
}
