package array.question26;

/**
 * Created by Administrator on 2017/12/17.
 */
public class RemoveElement {
    //要求in-place 空间复杂度=0
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
