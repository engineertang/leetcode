package array;

import java.util.Arrays;

public class Question414 {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int maximum = nums[nums.length - 1];
        int count = 1;
        int i = nums.length - 2;
        for (; i >= 0 && count < 3; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
        }
        int thirdMaximum = count == 3 ? nums[i + 1] : maximum;
        return thirdMaximum;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 2, 1, 1};
        System.out.println(thirdMax(array));
    }

}
