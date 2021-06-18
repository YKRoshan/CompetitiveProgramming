package com.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class dp4_GridTravelerWithMemoization {
    public static int gridTraveler(int n, int m, Map<String, Integer> memo) {
        String key = (Integer.toString(n) + "," + Integer.toString(m));
        if (memo.get(key) != null)
            return memo.get(key);
        if (n == 0 || m == 0)
            return 0;
        if (n == 1 && m == 1)
            return 1;
        memo.put(key, gridTraveler(n - 1, m, memo) + gridTraveler(n, m - 1, memo));
        return memo.get(key);
    }

    public static void main(String[] args) {
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(gridTraveler(2, 2, memo));
        System.out.println(gridTraveler(3, 2, memo));
        System.out.println(gridTraveler(5, 5, memo));
        System.out.println(gridTraveler(50, 50, memo));
    }
}
