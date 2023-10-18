package com.sorting;

public class BumbleSorting {
    /**
     * 冒泡排序是最基础的排序算法，由于其直观性，经常作为首个介绍的排序算法。其原理为：
     *
     * 内循环： 使用相邻双指针 j , j + 1 从左至右遍历，依次比较相邻元素大小，若左元素大于右元素则将它们交换；遍历完成时，
     * 最大元素会被交换至数组最右边 。
     * 外循环： 不断重复「内循环」，每轮将当前最大元素交换至 剩余未排序数组最右边 ，直至所有元素都被交换至正确位置时结束。
     *
     */
    void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i -1; j++) {
                if(nums[j] > nums[j+1]){
                    //交换
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    // optimized bubble sorting
    void bubbleSort2(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            boolean flag = false; // 初始化标志位 // 增加一个flag,减小时间复杂度
            for (int j = 0; j < N - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;  // 记录交换元素
                }
            }
            if (!flag) break;     // 内循环未交换任何元素，则跳出
        }
    }
}
