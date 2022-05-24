package array;

import java.util.Arrays;

public class Question88 {
    public static void main(String[] args) {
        /*String[] array = {"latte", "capuccino", "ice-american","mocha", "flat-white"};
        String s = array[0];
        //array[5] = "espresso";
        Arrays.stream(array).forEach(value -> System.out.println(value));*/
        Question88 arrayLibrary = new Question88();
//        int[] original = new int[]{1, 0, 2, 3, 0, 0} ;
//        arrayLibrary.duplicateZeros(original);
//        Arrays.stream(original).forEach(value -> System.out.println(value));

        int[] original = new int[]{1, 2, 3, 0, 0, 0};
        arrayLibrary.merge(original, 3, new int[]{-1, 5, 6}, 3);
        Arrays.stream(original).forEach(value -> System.out.println(value));

    }

    // question 88
    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    // output:           ,6
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (n != 0 && m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        //  Two-Pointer Approach: from ending point to start point, compare seperately  不适用额外的内存空间
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }


        // 排序
//        for(int i = m; i< m+n; i++){
//            nums1[i] = nums2[i-m];
//        }

        // from start to end compare seperately
//        int[] result = new int[m+n];
//        for(int k = 0, i =0, j = 0; k < m+n; k ++){
//            if ((i < m && j < n && nums1[i] <= nums2[j]) || j == n){
//                result[k] = nums1[i++];
//            }else {
//                result[k] = nums2[j++];
//            }
//        }
//
//        for(int i = 0; i< m+n; i++){
//            nums1[i] = result[i];
//        }
    }

    // question1089
    // original:  1,0,2,3,0,0
    // output:    1,0,0,2,3,0
    public void duplicateZeros(int[] arr) {
        int[] intArray = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length && j < arr.length; i++) {
            if (arr[i] == 0) {
                intArray[j] = 0;
                if (j < arr.length - 1) {
                    intArray[j + 1] = 0;
                }
                j = j + 2;
            } else {
                intArray[j] = arr[i];
                j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = intArray[i];
        }
    }
}
