package com.array.question41;

//question 268
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total = +num;
        }
        int sum = (nums.length) * (nums.length + 1) / 2;

        return (sum - total);
    }
}
