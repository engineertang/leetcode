package hashSetAndMap;

import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }else if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
        }

        Integer[] result = set.stream().toArray(value -> new Integer[1]);
        return  result[0];

    }


}
