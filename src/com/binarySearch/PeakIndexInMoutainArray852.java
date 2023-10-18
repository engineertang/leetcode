package com.binarySearch;

public class PeakIndexInMoutainArray852 {
    // O(n) for循环比较后面的数比前面数大，直到不再大了
    // O(log(n))
    public int peakIndexInMountainArray(int[] nums) {
        int head = 0, tail = nums.length - 1;
        // 模板2
        while (head + 1 < tail) {
            int middle = head + (tail - head) / 2;
            if (nums[middle] > nums[middle - 1]) {
                head = middle;
            } else {
                tail = middle;
            }
        }

        // 终止条件： head+1 == tail
        if (nums[head] > nums[tail]) {
            return head;
        } else if (nums[head] < nums[tail]) {
            return tail;
        }

        return 0;
    }
}
