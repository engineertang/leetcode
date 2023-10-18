package com.binarySearch;

// 寻找峰值
// 查找需要访问数组中当前索引及其直接右邻居索引的元素或条件。

/**
 * 一种实现二分查找的高级方法。
 * 查找条件需要访问元素的直接右邻居。
 * 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。
 * 保证查找空间在每一步中至少有 2 个元素。
 * 需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件。
 */
public class PeakElement162 {
    // binary search template 1
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // length >= 2
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int left = 1, right = nums.length - 2;
        // left middle right
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            // 上坡必有顶
            if (nums[mid] < nums[mid - 1]) { // 峰值在右侧
                right = mid - 1;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
        }

        return 0;
    }

    // binary search template 2  O(log n)  applied to middle point need to compare with neighboring point
    public int findPeakElement2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        // left middle right
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;   // middle + 1 is more likely to be target than middle
            } else if (nums[middle] > nums[middle + 1]) {
                right = middle; // not substract -1, middle probably is target
            }
        }

        // end point
        // left == right == middle
        return left;
    }

    // two loop  O(n)
    public int findPeakElement3(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // length >= 2
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

}
