package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class dp23_AllConstructUsingTabulation {
    public static List<List<String>> allConstruct(String target, List<String> wordBank) {
        List<List<List<String>>> tabulation = new ArrayList<>();
        tabulation.add(new ArrayList<>());
        tabulation.get(0).add(new ArrayList<>());
        for (int i = 0; i < target.length(); i++) {
            tabulation.add(new ArrayList<>());
        }

        for (int i = 0; i <= target.length(); i++) {
            if (tabulation.get(i).isEmpty()) {
                continue;
            }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (!word.startsWith(prefix)) {
                    continue;
                }
                List<List<String>> current = tabulation.get(i)
                    .stream()
                    .map(a -> new ArrayList<>(a))
                    .collect(Collectors.toList());
                current.forEach(arr -> arr.add(prefix));
                tabulation.get(i + prefix.length()).addAll(current);
            }
        }
        return tabulation.get(target.length());
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("abs", Arrays.asList("a", "dsa", "bs", "d")));
        System.out.println(allConstruct("skateboard", Arrays.asList("ska", "rd", "bbb", "ar")));
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            Arrays.asList("ee", "eee", "eeeee", "eeeeeeeeeeeeee")));
    }
}
