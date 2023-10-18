package array;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            map.put(i, (map.containsKey(i) ? (map.get(i) + 1) : 1));
        }

        return map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).
                collect(Collectors.toList()).get(0).getKey();
    }

    // binary search
//    摩尔投票法
//            思路
//    实际上，这种类型的题目可以使用摩尔投票法
//            该算法是指从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，即对冲消耗的思想
//    减到0就重新换个数开始计数，总能找到最多的那个
//    [2,2,3,3,4,4,4,4,4]
    public int binarySearch(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else if (candidate == nums[i])
                count++;
            else
                count--;
        }

        return candidate;
    }
}
