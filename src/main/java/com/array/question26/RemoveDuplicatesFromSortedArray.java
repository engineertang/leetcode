package com.array.question26;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/17.
 */
public class RemoveDuplicatesFromSortedArray {

    // In-place time Complixity: O(2N) space Complixity: O(1)
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //if(set.add(nums[i])){
            if (nums[i] != nums[i - 1]) {
                count++;
            }
        }

        //set = new HashSet<Integer>();
        for (int i = 1, j = 1; i < count && j < nums.length; ) {
            if (nums[j] != nums[j - 1] /*set.add(nums[j])*/) {
                nums[i] = nums[j];
                j++;
                i++;
            } else {
                j++;
            }
        }

        return count;
    }

    public int removeDuplicates2(int[] nums) {
        // transforms input using no auxiliary data structure. However a small amount of extra storage space is allowed for auxiliary variables.
        // In-place algorithm updates input sequence only through replacement or swapping of elements.
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates.removeDuplicates2(array);
        Arrays.stream(array).forEach(value -> System.out.printf(value + ", "));
    }
}
