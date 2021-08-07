package com.dynamicprogramming;

import java.util.*;

public class dp15_AllConstruct {
    public static List<List<String>> allConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> sufixWays = allConstruct(target.replaceFirst
                    (prefix, ""), wordBank);
                sufixWays.forEach(a -> a.add(0, prefix));
                result.addAll(sufixWays);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("abs", Arrays.asList("a", "dsa", "bs", "d")));
        System.out.println(allConstruct("skateboard", Arrays.asList("ska", "rd", "bbb", "ar")));
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("ee", "eee", "eeeee", "eeeeeeeeeeeeee")));
    }
}
