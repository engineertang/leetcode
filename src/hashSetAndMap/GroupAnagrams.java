package hashSetAndMap;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            if(!res.containsKey(sort(cur))){
                List a = new ArrayList<>();
                a.add(cur);
                res.put(sort(cur), a);
            }else {
                List a = res.get(sort(cur));
                a.add(cur);
                res.put(sort(cur), a);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: res.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
        /*StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars, 0, chars.length);
        return stringBuilder.toString();*/
    }


    public static void main(String[] args) {
        String res = sort("bcazk");
        System.out.println(res);
    }
}
