package com.array;

public class ValidateMountainArray941 {
    //
    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        int i = 0;
        while (arr[i] < arr[i + 1] && i < arr.length - 2) {//找到最大的值 mountain top: maximum value
            i++;
        }
        int top = i;
        if (i == 0)
            return false;
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1;
    }

    // solution2, 二分查找binary search
}
