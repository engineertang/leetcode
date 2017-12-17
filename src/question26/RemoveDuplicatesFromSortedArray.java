package question26;

/**
 * Created by Administrator on 2017/12/17.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        /*int i1 = nums.length;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                i1 --;

            }
        }
        return i1;*/

        // transforms input using no auxiliary data structure. However a small amount of extra storage space is allowed for auxiliary variables.
        //In-place algorithm updates input sequence only through replacement or swapping of elements.
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        for(int m = 0; m < nums.length; m++){
            System.out.println(nums[m] + " ");
        }
        return i + 1;
    }
}
