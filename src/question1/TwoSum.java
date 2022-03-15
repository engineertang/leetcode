package question1;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     */
    public int[] twoSum(int[] nums, int target) throws Exception {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
           for(int j = 0 ; j < nums.length; j ++){
               if(nums[i] + nums[j] == target){
                   result[0] = i;
                   result[1] = j;
                   return  result;
               }
           }
        }

        throw  new Exception();
    }

    /**
     * Time complexity : O(n*2)
     * Space complexity : O(n)
     * HashMap
     */
    public int[] twoSum2(int[] nums, int target) throws Exception {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(null != map.get(target - nums[i])){
                return new int[] {i, map.get(target - nums[i])};
            }
        }

        throw new IllegalArgumentException("can't get correct result");
    }
}