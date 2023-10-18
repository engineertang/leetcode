package array;

import java.util.Arrays;

public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
        /**
         * 从i=0开始循环，直到i==right,或left == right
         * 判断第i个数字是不是偶数，
         *     是偶数: swap到left
         *     是奇数，swap到right
         *  left：记录left之前的都是已完成排序的偶数
         *  right  记录right之后的是已完成排序的奇数
         *
         *  3  1  2  4
         *
         */
        int left = 0, right = nums.length - 1;

        while (left < right) {
            boolean isEven = nums[left] % 2 == 0;
            if (isEven) {
                left++;
            } else {
                swap(nums, left, right);
                right--;
            }
        }

        return nums;
    }

    public int[] sortArrayByParity2(int[] A) {
        int i = -1;
        for (int j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                i += 1;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

    public int[] sortArrayByParity3(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        SortArrayByParity905 sortArrayByParity905 = new SortArrayByParity905();
        int[] array = {3, 1, 2, 4};
        sortArrayByParity905.sortArrayByParity3(array);
        Arrays.stream(array).forEach(value -> System.out.printf(value + ", "));
    }

}
