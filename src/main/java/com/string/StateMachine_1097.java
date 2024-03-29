package com.string;

import java.util.HashMap;
import java.util.Map;

// Question 1097
public class StateMachine_1097 {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }}, // 0.
                new HashMap<Object, Object>() {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.
                new HashMap<Object, Object>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap<Object, Object>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},              // 3.
                new HashMap<Object, Object>() {{
                    put('d', 3);
                }},                                        // 4.
                new HashMap<Object, Object>() {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.
                new HashMap<Object, Object>() {{
                    put('d', 7);
                }},                                        // 6.
                new HashMap<Object, Object>() {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.
                new HashMap<Object, Object>() {{
                    put(' ', 8);
                }}                                         // 8.
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t))
                return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    public static void main(String[] args) {
        StateMachine_1097 stateMachine1097 = new StateMachine_1097();
        boolean result = stateMachine1097.isNumber("-34.12E10");
        System.out.println(result);
    }
}
