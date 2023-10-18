package com.sorting;

import java.util.Arrays;

public class InsertionSorting {
    /**
     * 插入排序是，其原理为：
     *
     * 内循环： 使用相邻双指针 j , j - 1 从右至左遍历，依次比较相邻元素大小，若左元素大于右元素则将它们交换；
     * 遍历完成时，前j个数是有序的。
     * 外循环： 不断重复「内循环」，每轮将当前左边的i+1个元素交换至有序 ，直至所有元素都被交换至正确位置时结束。
     *
     */
    public void insertionSorting(int[] nums){
        for (int i = 1; i < nums.length ; i++) {
            for (int j = i ; j > 0; j--) {
                //
                if (nums[j-1] > nums[j] ){
                    //swap交换
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4,3,2,5};
        InsertionSorting insertionSorting = new InsertionSorting();
        insertionSorting.insertionSorting(array);

        Arrays.stream(array).forEach(value -> System.out.println(value));
    }
}
