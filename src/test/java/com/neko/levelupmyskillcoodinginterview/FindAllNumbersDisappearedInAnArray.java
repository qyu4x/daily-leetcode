package com.neko.levelupmyskillcoodinginterview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    @Test
    void test() {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1 ; i <= nums.length; i++) {
            boolean isFound = false;

            int low = 0;
            int high = nums.length-1;

            while(high >= low) {
                int mid = (high + low) / 2;

                if (nums[mid] == i) {
                    isFound = true;
                    break;
                } else if (nums[mid] < i) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (!isFound) {
                result.add(i);
            }
        }

        return result;
    }
}
