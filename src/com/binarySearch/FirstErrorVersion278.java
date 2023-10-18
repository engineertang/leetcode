package com.binarySearch;

public class FirstErrorVersion278 {
    // eg.  0000111111
    public int firstBadVersion(int nums) {
        if (nums == 1)
            return -1;

        int left = 1, right = nums;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;   // 找到第一个坏的版本，此处不减1
            } else if (!isBadVersion(mid)) {
                left = mid + 1;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (left == right && isBadVersion(left))
            return left;
        return -1;
    }

    //The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version) {
        return false;
    }
}
