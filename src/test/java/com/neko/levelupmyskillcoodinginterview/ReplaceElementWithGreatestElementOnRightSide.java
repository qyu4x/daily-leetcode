package com.neko.levelupmyskillcoodinginterview;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReplaceElementWithGreatestElementOnRightSide {

    @Test
    void testLeetCode1299() {
        /**
         * replace every element in that array with the greatest among the element to its right and replace last element with -1
         */

        int[] arr = {17, 18, 5, 4, 6, 1};
        // expect result
        // arr [18, 6, 6, 6, 1, -1]

        for (int i = 0; i < arr.length; i++)  {
            int replacement = 0;
            if (i == arr.length-1) {
                arr[i] = -1;
                break;
            }

            int greatest = arr[i+1];
            for (int j = i+1; j < arr.length; j++) {
                int current = j + 1;
                if (current >= arr.length-1) {
                    replacement = greatest;
                    break;
                }

                if (greatest < arr[current]) {
                    greatest = arr[current];
                    replacement = greatest;

                }else {
                    replacement = greatest;
                }
            }

            arr[i] = replacement;

        }

        int expected[] = {18, 6, 6, 6, 1, -1};
        Assertions.assertTrue(Arrays.equals(expected, arr));

    }
}
