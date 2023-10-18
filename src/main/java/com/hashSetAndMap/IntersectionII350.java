package com.hashSetAndMap;

import java.util.*;

public class IntersectionII350 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res  = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            }else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])){
                res.add(nums2[i]);
                if(map.get(nums2[i])==1){
                    map.remove(nums2[i]);
                }else
                    map.put(nums2[i], map.get(nums2[i]) -1);
            }
        }

        return res.stream().mapToInt(value -> value).toArray();
    }


}
