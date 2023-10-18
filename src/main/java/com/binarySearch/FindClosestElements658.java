package com.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements658 {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        String s = "";
        int left = 0, right = nums.length - 1;

        /**
         * [1,2,3,4,5]
         * 4
         * 3
         */
        while (left + 1 < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) {
                right = mid;
            } else if (nums[mid] < x) {
                left = mid;
            } else if (nums[mid] > x) {
                right = mid;
            }
        }

        /** Post-processing:
         * End Condition: left + 1 == right
         * left ,right  双指针，逐渐扩大，k是计算器，向两边数k个数
         */
        List<Integer> ans = new ArrayList<>();
        while (k-- > 0) {
            // Math.abs(nums[left] - x) <= Math.abs(nums[right] - x)： 如果左侧差值更小，向左拓展；差值相同情况下，左边的值更小，也向左拓展，否则向右拓展。
            // left >= 0 ：防止向左越界，不能再向左继续拓展
            // right >= n: 防止右边越界，不能再向右继续拓展
            if (right >= nums.length - 1 || (left >= 0 && Math.abs(nums[left] - x) <= Math.abs(nums[right] - x))) {
                ans.add(0, nums[left--]);
            } else {
                ans.add(nums[right++]);
            }
        }
        return ans;

        
        /*if (Math.abs(nums[left] - x) <= Math.abs(nums[right] - x))
            return left;
        else
            return right;*/

    }
}
