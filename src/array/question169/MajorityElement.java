package array.question169;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums){
            map.put(i, (map.containsKey(i) ? (map.get(i) + 1) : 1));
        }

        return map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).
                collect(Collectors.toList()).get(0).getKey();
    }
}
