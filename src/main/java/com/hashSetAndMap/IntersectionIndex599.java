package com.hashSetAndMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class IntersectionIndex599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        List<String> res = new ArrayList<>();

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet() ) {
            if (map2.containsKey(entry.getKey())) { // 交集
                if((entry.getValue() + map2.get(entry.getKey())) < minSum) {
                    res.clear();
                    res.add(entry.getKey());
                }else if ((entry.getValue() + map2.get(entry.getKey())) == minSum) {
                    res.add(entry.getKey());
                }
                minSum = Math.min(minSum, entry.getValue() + map2.get(entry.getKey()));
            }
        }
        return res.stream().toArray(String[] :: new);
    }

}
