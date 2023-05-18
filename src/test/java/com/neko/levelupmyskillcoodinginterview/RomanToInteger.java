package com.neko.levelupmyskillcoodinginterview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {

    @Test
    void testRomanToInteger() {
        System.out.println(romanToInt("MDCXCV"));
    }

    public int romanToInt(String s) {
        Map<String, Integer> pattern =
                Map.of(
                        "I", 1,
                        "V", 5,
                        "X", 10,
                        "L", 50,
                        "C", 100,
                        "D", 500,
                        "M", 1000
                );


        List<String> sameValues = new ArrayList<>();

        if (s.length() == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean stop = false;
            for (int j = index; j < s.length(); j++) {
                if (s.charAt(index) == s.charAt(j) && j == s.length() - 1) {
                    String currentSameValue = s.substring(index, j + 1);
                    if (currentSameValue.length() > 3) {
                        String remainingResult = currentSameValue.substring(3, currentSameValue.length());
                        sameValues.add(currentSameValue.substring(0, 3));
                        sameValues.add(remainingResult);
                    } else {
                        sameValues.add(currentSameValue);
                    }
                    stop = true;
                }

                if (s.charAt(index) != s.charAt(j)) {
                    String currentSameValue = s.substring(index, j);
                    sameValues.add(currentSameValue);
                    index = j;
                }
            }
            if (stop) {
                break;
            }
        }

        int result = 0;
        if (sameValues.size() == 1) {
            Integer s1Value = pattern.get(String.valueOf(sameValues.get(0).charAt(0)));
            int s1Length = sameValues.get(0).length();

            return s1Value * s1Length;
        }

        for (int i = 0; i < sameValues.size() - 1; i++) {
            System.out.println(i);
            if ((sameValues.get(i).length() == 1) && (sameValues.get(i + 1).length() == 1) && ((sameValues.get(i).equals("I") && (sameValues.get(i + 1).equals("V")) || ((sameValues.get(i).equals("I") && (sameValues.get(i + 1).equals("X"))))))) {
                Integer s1ValueI = pattern.get("I");
                Integer s1VorX = pattern.get(String.valueOf(sameValues.get(i + 1).charAt(0)));
                int currentResult = s1VorX - s1ValueI;
                result += currentResult;
                System.out.println("ehe " + i);
                i++;
            } else if ((sameValues.get(i).length() == 1) && (sameValues.get(i + 1).length() == 1) && ((sameValues.get(i).equals("X") && (sameValues.get(i + 1).equals("L")) || ((sameValues.get(i).equals("X") && (sameValues.get(i + 1).equals("C"))))))) {
                Integer s1ValueL = pattern.get("X");
                Integer s1LorC = pattern.get(String.valueOf(sameValues.get(i + 1).charAt(0)));
                int currentResult = s1LorC - s1ValueL;
                result += currentResult;
                System.out.println("ehe " + i);

                System.out.println(currentResult);
                i++;
            } else if ((sameValues.get(i).length() == 1) && (sameValues.get(i + 1).length() == 1) && ((sameValues.get(i).equals("C") && (sameValues.get(i + 1).equals("D")) || ((sameValues.get(i).equals("C") && (sameValues.get(i + 1).equals("M"))))))) {
                Integer s1ValueC = pattern.get("C");
                Integer s1DorM = pattern.get(String.valueOf(sameValues.get(i + 1).charAt(0)));
                int currentResult = s1DorM - s1ValueC;
                System.out.println("ehe " + i);

                result += currentResult;
                i++;
            } else {
                System.out.println("last " + i);
                if (i == sameValues.size() - 2) {
                    System.out.println(sameValues.get(i+1));
                    int s1Length = sameValues.get(i + 1).length();
                    Integer s1Value = pattern.get(String.valueOf(sameValues.get(i + 1).charAt(0)));
                    result += s1Value * s1Length;
                }
                int s1Length = sameValues.get(i).length();
                Integer s1Value = pattern.get(String.valueOf(sameValues.get(i).charAt(0)));
                result += s1Value * s1Length;


            }
        }

        return result;
    }
}
