package com.neko.levelupmyskillcoodinginterview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MissingNumber {

    @Test
    void testMissingNumber() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingValueBestSolution(nums));
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            if (!binarySearch(nums, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        Arrays.sort(nums);
        while (high >= low) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public int missingValueBestSolution(int[] nums) {
        int n = nums.length;
        int expectedResult = n * (n + 1) / 2;

        int actualResult = 0;
        for (int i = 0; i < n; i++) {
            actualResult += nums[i];
        }

        return expectedResult-actualResult;
    }
}
