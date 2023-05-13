package com.neko.levelupmyskillcoodinginterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeNumber {

    @Test
    void testLeetCode9() {
        /**
         * Given an integer x, return true if x is a
         * palindrome
         * ,and false otherwise.
         *
         * Input: x = -121
         * Output: false
         * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
         */
        int x = 121;
        String xs = String.valueOf(x);

        boolean status = true;
        for (int i = 0; i < xs.length(); i++) {
            String currentValue = String.valueOf(xs.charAt(i));

            if (!currentValue.equals(String.valueOf(xs.charAt(xs.length()-1-i)))) {
                status = false;
            }
        }

        Assertions.assertTrue(status);
    }

}
