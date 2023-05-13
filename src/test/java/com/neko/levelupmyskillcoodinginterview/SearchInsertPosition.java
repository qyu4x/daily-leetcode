package com.neko.levelupmyskillcoodinginterview;

import org.junit.jupiter.api.Test;

public class SearchInsertPosition {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity
     * <p>
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     */

    @Test
    void testSearchInsert() {
        int nums[] = {1,3,5,6};
        int index = searchInsert(nums, 0);
        System.out.println(index);

    }


    public int searchInsert(int[] nums, int target) { // this algorithm is binary search with time complexity log n
        int low = 0;
        int high = nums.length - 1;

        if (nums[nums.length - 1] < target )
            return nums.length;

        while (high >= low) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (mid == 0 && target > nums[mid])
                return mid + 1;
            else if (mid == 0 && target < nums[mid]) {
                return mid;
            }
            else if (nums[mid-1] < target && nums[mid] > target) {
                return mid;
            }
        }

        return -1;

    }

}
