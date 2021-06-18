package com.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class dp6_CanSumWithMemoization {

    public static boolean canSum(int n, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(n))
            return memo.get(n);
        for (int i : numbers) {
            if (n - i == 0) {
                memo.put(n, true);
                return true;
            }

        }
        boolean result = false;
        for (int i : numbers) {
            boolean res = false;
            if (n - i > 0) {
                res = canSum(n - i, numbers, memo);
                result = result || res;
            }
            memo.put(n - i, res);
        }
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Boolean> memo = new HashMap<>();
        System.out.println(canSum(7, new int[]{4, 3, 6, 7}, memo));
        System.out.println(canSum(2, new int[]{4, 3, 6, 7}, memo));
        System.out.println(canSum(9, new int[]{7, 5, 8}, memo));
        System.out.println(canSum(5, new int[]{2, 3, 6}, memo));
        System.out.println(canSum(3000, new int[]{7, 14}, memo));
    }
}
