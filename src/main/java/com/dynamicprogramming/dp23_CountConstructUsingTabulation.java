package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp23_CountConstructUsingTabulation {
    public static int countConstruct(String target, List<String> wordBank) {
        List<Integer> tabulation = new ArrayList<>();
        tabulation.add(1);
        for (int i = 0; i < target.length(); i++) {
            tabulation.add(0);
        }

        for (int i = 0; i < target.length(); i++) {
            if (tabulation.get(i) == 0) {
                continue;
            }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    tabulation.set(
                        i + prefix.length(),
                        tabulation.get(i) + tabulation.get(i + prefix.length())
                    );
                }
            }
        }
        return tabulation.get(target.length());
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("abs", Arrays.asList("a", "dsa", "bs", "d")));
        System.out.println(countConstruct("skateboard", Arrays.asList("ska", "rd", "bbb", "ar")));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("eee", "eeeeeee", "eeeeeeee",
                "eeeeeeeeeeeeeeeeeeeeeeeeeeee")));
    }
}
