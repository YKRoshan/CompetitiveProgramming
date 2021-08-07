package com.dynamicprogramming;

import java.util.*;

public class dp14_CountConstructWithMemoization {
    public static Integer countConstruct(String target, List<String> wordBank) {
        return countConstructMemo(target, wordBank, new HashMap<>());
    }

    private static Integer countConstructMemo(String target, List<String> wordBank, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return 1;
        }
        Integer sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) {
                continue;
            }
            sum += countConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo);
        }
        memo.put(target, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("abs", Arrays.asList("a", "dsa", "bs", "d")));
        System.out.println(countConstruct("skateboard", Arrays.asList("ska", "rd", "bbb", "ar")));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("eee", "eeeeeee", "eeeeeeee",
                "eeeeeeeeeeeeeeeeeeeeeeeeeeee")));
    }
}
