package com.dynamicprogramming;

public class dp19_CanSumUsingTabulation {
    public static boolean canSum(int targetSum, int[] numbers) {
        boolean[] tabulation = new boolean[targetSum + 1];
        tabulation[0] = true;
        for (int i = 0; i < targetSum; i++) {
            for (Integer number : numbers) {
                if (tabulation[i] && i + number <= targetSum) {
                    tabulation[i + number] = true;
                }
            }
        }
        return tabulation[targetSum];
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{4, 3, 6, 7}));
        System.out.println(canSum(2, new int[]{4, 3, 6, 7}));
        System.out.println(canSum(9, new int[]{7, 5, 8}));
        System.out.println(canSum(5, new int[]{2, 3, 6}));
        System.out.println(canSum(3000, new int[]{7, 14}));
    }
}
