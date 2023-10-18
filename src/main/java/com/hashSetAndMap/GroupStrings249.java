package com.hashSetAndMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//249. 移位字符串分组
public class GroupStrings249 {

    public List<List<String>> groupStrings(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            if (!res.containsKey(sort(cur))) {
                List a = new ArrayList<>();
                a.add(cur);
                res.put(sort(cur), a);
            } else {
                List a = res.get(sort(cur));
                a.add(cur);
                res.put(sort(cur), a);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : res.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    // 将字符串移位, 直到首字母为a
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        while (chars[0] != 'a') {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'z') {
                    chars[i] = 'a';
                } else {
                    chars[i] = (char) (chars[i] + 1);
                }
            }
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        String[] array = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        GroupStrings249 groupStrings = new GroupStrings249();
        System.out.println(groupStrings.groupStrings(array));
    }
}
