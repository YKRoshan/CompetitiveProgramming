package com.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class dp13_CountConstruct {
    public static int countConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) {
            return 1;
        }
        int sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) {
                continue;
            }
            sum += countConstruct(target.replaceFirst(prefix, ""), wordBank);
        }
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
