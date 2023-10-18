package array;

import java.util.*;

public class FindDisappearedNumbers448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 1. extra space saving all numbers from 1 to n, linear tranverse nums, remove each from extra space, remaining number is answer
        //      add 比 remove省时，set装了全部数，linear loop from 1 to n, 在set进行是否包含判断，包含就跳过，不包含就记录
        //      extra space is List
        Set<Integer> extra = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            extra.add(nums[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!extra.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDisappearedNumbers448 findDisappearedNumbers448 = new FindDisappearedNumbers448();
        List list = findDisappearedNumbers448.findDisappearedNumbers(array);
        list.forEach(value -> System.out.println(value + " ,"));
    }
}
