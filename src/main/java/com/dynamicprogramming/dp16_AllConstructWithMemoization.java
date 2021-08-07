package com.dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class dp16_AllConstructWithMemoization {
    public static List<List<String>> allConstruct(String target, List<String> wordBank) {
        return allConstructMemo(target, wordBank, new HashMap<>());
    }

    private static List<List<String>> allConstructMemo(String target, List<String> wordBank,
                                                       HashMap<String,
        List<List<String>>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> suffixWays = allConstructMemo(target.replaceFirst
                    (prefix, ""), wordBank, memo)
                    .stream()
                    .map(a -> new ArrayList<>(a))
                    .collect(Collectors.toList());
                suffixWays.forEach(a -> a.add(0, prefix));
                result.addAll(suffixWays);
            }
        }
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("abs", Arrays.asList("a", "dsa", "bs", "d")));
        System.out.println(allConstruct("skateboard", Arrays.asList("ska", "rd", "bbb", "ar")));
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("ee", "eee", "eeeee", "eeeeeeeeeeeeee")));
    }
}
