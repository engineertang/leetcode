package com.array;

import java.util.Arrays;

public class DuplicateZeros1089 {
    public void duplicateZeros(int[] arr) {
        //Two pass, O(1) space
        // [1,0,2,3,0,4,5,0]
        // [1,0,0,2,3,0,0,4,5,0,0]
        int slow = -1, fast = -1;
        for (int i = 0; i < arr.length; i++) {
            slow++;
            if (arr[i] == 0) {
                fast = fast + 2;
            } else
                fast++;
        }

//        while (slow >= 0) {
//            if (fast < arr.length) {
//                arr[fast] = arr[slow];
//            }
//            if (arr[slow] == 0) {
//                fast--;
//                if (fast < arr.length) {
//                    arr[fast] = arr[slow];
//                }
//            }
//
//            slow--;  fast--;
//        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (fast < arr.length) {
                arr[fast] = arr[i];
            }
            if (arr[i] == 0) {
                fast--;
                if (fast < arr.length) {
                    arr[fast] = arr[i];
                }
            }
            fast--;
        }
    }

    public static void main(String[] args) {
        DuplicateZeros1089 question1089 = new DuplicateZeros1089();
        int[] array = {8, 4, 5, 0, 0, 0, 0, 7};
        // 8,4,5,0,0,0,0,7
        // 8,4,5,0,0,0,0,0,0,0,0,7
        question1089.duplicateZeros(array);
        Arrays.stream(array).forEach(value -> System.out.println(value));
    }

    public void duplicateZeros2(int[] arr) {
        int[] duplicate = new int[arr.length];

        for (int i = 0, j = 0; i < arr.length && j < arr.length; i++, j++) {
            duplicate[j] = arr[i];
            if (arr[i] == 0 && j + 1 < arr.length) {
                duplicate[++j] = 0;
            }
        }

        System.arraycopy(duplicate, 0, arr, 0, arr.length);
    }
}
