package com.string;

import java.util.Arrays;
import java.util.List;

public class Question7 {
    public int reverse(int x) {
        int[] array = new int[10];
        int i = 0;
        do {
            array[i++] = x % 10;
            x = x / 10;
        } while (x != 0);

        int result = 0;
        int j = 0;
        do {
            if (Math.abs(result) > (Math.pow(2, 31) - 1) / 10) {
                return 0;
            }
            result = result * 10 + array[j++];
        } while (j < i);

        Arrays.stream(array).forEach(System.out::println);
        System.out.printf(Integer.toString(result));

        return result;
    }

    public List<String> fizzBuzz(int n) {
        String[] result = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz";
            } else if (i % 3 == 0 && i % 5 != 0) {
                result[i] = "Fizz";
            } else if (i % 3 != 0 && i % 5 == 0) {
                result[i] = "Buzz";
            } else {
                result[i] = Integer.toString(i);
            }
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        Question7 question7 = new Question7();
        question7.reverse(123);
    }
}
