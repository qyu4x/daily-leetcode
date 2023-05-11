package com.neko.levelupmyskillcoodinginterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoSum {

    @Test
    void test1() {

        /**
         * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target
         * Input: nums = [2,7,11,15], target = 9
         * Output: [0,1]
         * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         */

        int target = 6;
        int nums[] = {3,2,4};
        int result[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int base = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                  int currentResult = base + nums[j];
                  if (currentResult == target) {
                      if (i < j) {
                          result[0] = i;
                          result[1] = j;
                      } else {
                          result[0] = j;
                          result[1] = i;
                      }
                  }
                }
            }
        }

        int expected[] = {1, 2};
        Assertions.assertTrue(Arrays.equals(expected, result));
    }
}
