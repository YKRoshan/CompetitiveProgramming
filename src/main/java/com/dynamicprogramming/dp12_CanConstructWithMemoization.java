package com.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class dp12_CanConstructWithMemoization {
    public static boolean canConstruct(String target, List<String> wordBank) {
        return canConstructMemo(target, wordBank, new HashMap<>());
    }

    private static boolean canConstructMemo(String target, List<String> wordBank, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return true;
        }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) {
                continue;
            }
            if (canConstructMemo(target.replaceFirst(subWord, ""), wordBank, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abs", Arrays.asList("a", "dsa", "bs", "d")));
        System.out.println(canConstruct("skateboard", Arrays.asList("ska", "rd", "bbb", "ar")));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("eee", "eeeeeee", "eeeeeeee",
                "eeeeeeeeeeeeeeeeeeeeeeeeeeee")));
    }
}
