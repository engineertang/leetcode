package com.sorting;

import java.util.Arrays;

public class MergeSorting {

    public void mergeSort(int[] nums, int l, int r) {
        // 终止条件
        if (l >= r) return;
        // 递归划分
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        // 合并子数组
        int[] tmp = new int[r - l + 1]; // 暂存需合并区间元素
        if (r + 1 - l >= 0) System.arraycopy(nums, l, tmp, l - l, r + 1 - l);
        int i = 0, j = m - l + 1;       // 两指针分别指向左/右子数组的首个元素
        for (int k = l; k <= r; k++) {  // 遍历合并左/右子数组
            if (i == m - l + 1)
                nums[k] = tmp[j++];
            else if (j == r - l + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
            }
        }
    }


    public static void main(String[] args) {
        // 调用
        int[] nums = {3, 4, 1, 5, 2, 1};
        MergeSorting mergeSorting = new MergeSorting();

        mergeSorting.mergeSort(nums, 0, nums.length - 1);

        Arrays.stream(nums).forEach(value -> System.out.printf(Integer.toString(value)));
    }
}
