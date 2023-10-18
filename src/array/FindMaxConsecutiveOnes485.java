package array;

import org.junit.Assert;

/**
 *
 */
public class FindMaxConsecutiveOnes485 {
    // question 485
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            if (nums[left] == 0) continue;
            int right = left;
            while (right + 1 < nums.length && nums[right + 1] == 1) {
                right++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        FindMaxConsecutiveOnes485 instance = new FindMaxConsecutiveOnes485();
        int result = instance.findMaxConsecutiveOnes(nums);
        Assert.assertEquals(result, 3);

        //Arrays.stream(result).forEach(value -> System.out.println(value));
    }
}
