package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class RelativeSortArray1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr2 {num : index}
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Integer[] array1 = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            array1[i] = arr1[i];
        }

        Arrays.sort(array1, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (map.containsKey(o1) && map.containsKey(o2)) { // 都有
                    return map.get(o1) - map.get(o2);
                } else if (!map.containsKey(o1) && !map.containsKey(o2)) { //都没有
                    return o1 - o2;
                } else if (!map.containsKey(o1) && map.containsKey(o2)) { // 没有o1,把o2排在前面
                    return 1;
                } else if (map.containsKey(o1) && !map.containsKey(o2)) {
                    return -1;
                }
                return 1;
            }
        });

        for (int i = 0; i < array1.length; i++) {
            arr1[i] = array1[i];
        }
        return arr1;
    }
}
