package com.array.question1;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * linear loop 线性循环
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     */
    public int[] twoSum(int[] nums, int target) throws Exception {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        throw new Exception();
    }

    /**
     * HashMap 时间复杂度变小
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public int[] twoSum2(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (null != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        throw new IllegalArgumentException("can't get correct result");
    }
}