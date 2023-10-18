package com.array.question15;

import java.util.*;
import java.util.stream.Collectors;


public class SumOf3 {
    // HashMap
    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    // 时间复杂度O(n^3)
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] > 0 || nums[i] + nums[j] + nums[j + 1] > 0) {
                    break;
                }
                if (nums[i] + nums[j] == 0 && nums[j + 1] == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[j + 1]}));
                    break;
                }
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[k] < 0 || nums[i] + nums[j] + nums[k] < 0) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                        break;
                    }
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }
}
