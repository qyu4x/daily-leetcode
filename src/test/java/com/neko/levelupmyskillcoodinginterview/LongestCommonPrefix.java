package com.neko.levelupmyskillcoodinginterview;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string ""
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     */

    @Test
    void testLongestCommonPrefix() {

        String[] strs = {"a","a","a"};
        String commonPrefix = longestCommonPrefix(strs);
        System.out.println(commonPrefix);

    }

    public String longestCommonPrefix(String[] strs) {
        Set<String> tempPrefix = new HashSet<>();
        Map<String, Integer> tempCount = new HashMap<>();

        int end = 0;
        for (int i = 0; i < strs.length; i++) {

            if (strs[i].length() == 0) {
                return "";
            }
            if (strs[i].length() == 1) {
                tempPrefix.add(String.valueOf(strs[i].charAt(0)));
            } else {
                String prefix = strs[i].substring(0, 2);
                tempPrefix.add(prefix);
            }
        }

        tempPrefix.forEach(pf -> {
            for (int i = 0; i < strs.length; i++) {
                if (strs[0].length() > 1) {
                    if (strs[i].substring(0,2).equals(pf)) {
                        if (tempCount.containsKey(pf)) {
                            Integer current = tempCount.get(pf) + 1;
                            tempCount.put(pf, current);
                        } else {
                            tempCount.put(pf, 1);
                        }
                    }
                } else {
                    if (String.valueOf(strs[i].charAt(0)).equals(pf)) {
                        if (tempCount.containsKey(pf)) {
                            Integer current = tempCount.get(pf) + 1;
                            tempCount.put(pf, current);
                        } else {
                            tempCount.put(pf, 1);
                        }
                    }
                }
            }
        });

        AtomicBoolean isSameCheckers = new AtomicBoolean(false);
        for (String key : tempCount.keySet()) {
            if (tempCount.get(key) != 1) {
                isSameCheckers.set(true);
                break;
            }
        }

        if (!isSameCheckers.get()) {
            return "";
        }

        int biggest = -1;
        for (Map.Entry<String, Integer> entry : tempCount.entrySet())  {
            if (entry.getValue() > biggest) {
                biggest = entry.getValue();
            }
        }

        String key = "";
        for (Map.Entry<String, Integer> entry : tempCount.entrySet())  {
            if (Integer.valueOf(biggest).equals(entry.getValue())) {
                key = entry.getKey();
            }
        }

        return key;
    }

}
