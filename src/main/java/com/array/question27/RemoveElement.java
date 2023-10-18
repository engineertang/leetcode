package com.array.question27;

import java.util.HashMap;
import java.util.Map;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
//        int pointer = nums.length ;
//        for(int i = 0; i < pointer; i++){
//            while(nums[i] == val && i < pointer){
//                pointer--;
//
//                int temp = nums[i];
//                nums[i] = nums[pointer];
//                nums[pointer] = temp;
//            }
//        }
//        return pointer;


        //Fast & Short Java Solution   two pointer
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            } else {
                continue;
            }
        }
        return slow;
    }

    public boolean checkIfExist(int[] arr) {
        Map map = new HashMap<>();
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            int multi = arr[i] * 2;
            int half = arr[i] % 2 == 0 ? arr[i] / 2 : 1001;
            if (map.containsKey(multi) || map.containsKey(half)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        int i = 0;
        while (arr[i] < arr[i + 1] && i < arr.length - 2) {
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


    public static void main(String[] args) {
//        int[] nums = {2,2,3}; // Input array
//        int val = 2; // Value to remove
//        int[] expectedNums = {3}; // The expected answer with correct length.
//        // It is sorted with no values equaling val.
//
//        int k = RemoveElement.removeElement(nums, val); // Calls your implementation
//
//        if (k != expectedNums.length) throw new AssertionError();
//        Arrays.sort(nums, 0, k); // Sort the first k elements of nums
//        for (int i = 0; i < expectedNums.length; i++) {
//            if (nums[i] != expectedNums[i]) throw new AssertionError();
//        }


        int[] arrs = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        boolean result = validMountainArray(arrs);
        System.out.println(result);
    }
}
