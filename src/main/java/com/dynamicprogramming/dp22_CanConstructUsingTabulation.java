package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp22_CanConstructUsingTabulation {
    public static boolean canConstruct(String target, List<String> wordBank) {
        List<Boolean> tabulation = new ArrayList<>();
        tabulation.add(true);
        for (int i = 0; i < target.length(); i++) {
            tabulation.add(false);
        }

        for (int i = 0; i < target.length(); i++) {
            if (!tabulation.get(i)) {
                continue;
            }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    tabulation.set(i + prefix.length(), true);
                }
                if (tabulation.get(target.length())) {
                    return true;
                }
            }
        }
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
