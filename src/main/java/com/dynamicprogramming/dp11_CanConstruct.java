package com.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dp11_CanConstruct {
    public static boolean canConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) {
            return true;
        }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) {
                continue;
            }
            if (canConstruct(target.replaceFirst(subWord, ""), wordBank)) {
                return true;
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
