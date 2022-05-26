package hashSetAndMap;

import java.util.*;

public class Isomorphic205 {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!dic.containsKey(s.charAt(i))){
                dic.put(s.charAt(i), t.charAt(i));
            }else {
                if(dic.get(s.charAt(i)) != t.charAt(i) ){
                    return false;
                }
            }
        }

        HashSet<Character> set = new HashSet<>();
        for(Map.Entry<Character, Character> entry : dic.entrySet()){
            if(!set.add(entry.getValue()))
                return false;
        }

        return true;
    }
}
