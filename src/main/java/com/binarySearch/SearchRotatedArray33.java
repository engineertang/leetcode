package com.binarySearch;

public class SearchRotatedArray33 {
    public int search(int[] nums, int target) {
        if (nums.length <= 2) {
            return nums[0] == target || nums[1] == target ? (nums[0] == target ? 0 : 1) : -1;
        }
        int from = 0, to = nums.length - 1;
        while (from <= to) {
            int middle = from + (to - from) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] >= nums[0]) {
                if ((target < nums[middle] && target >= nums[0])) {// 和左端点比较，在左边
                    to = middle - 1;
                } else { // 右边
                    from = middle + 1;
                }
            } else if (nums[middle] < nums[0]) {
                if (target > nums[middle] && target <= nums[nums.length - 1]) { // 在右边
                    from = middle + 1;
                } else {  // 左边
                    to = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedArray33 question33 = new SearchRotatedArray33();
        int result = question33.search(new int[]{5, 1, 2, 3, 4}, 1);
        System.out.println(result);
    }
}