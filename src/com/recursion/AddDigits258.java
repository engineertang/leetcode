package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//  AddDigit
public class AddDigits258 {

    public int addDigits(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num = num / 10;
        }
        int next = (int) list.stream().collect(Collectors.summarizingInt(value -> value)).getSum();

        if (next >= 10) {
            return addDigits(next);
        } else
            return next;
    }
}
