package com.recursion;

import java.util.HashMap;

// Question50
public class PowXandN {
    HashMap<Integer, Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        // n >0
        if (map.containsKey(n)) {
            map.get(n);
        }// (1,x)(2,) (4,) (8,)  ... (n/4, ) (n/2, )

        if (n == Integer.MIN_VALUE) {
            return myPow(x * x, n / 2);
        }
        if (n > 0) {
            if (n % 2 == 0) {
                double memory = myPow(x, n / 2);
                if (!map.containsKey(n / 2)) {
                    map.put(n / 2, memory);
                }
                double result = memory * memory;
                return result;
            } else {
                double memory = myPow(x, n / 2);
                if (!map.containsKey(n / 2)) {
                    map.put(n / 2, memory);
                }
                double result = memory * memory * x;
                return result;
            }
        } else if (n == 0) {
            return 1.0;
        } else
            return 1 / myPow(x, -n);
    }


    public static void main(String[] args) {
        PowXandN powXandN = new PowXandN();
        double d = powXandN.myPow(0.0001, Integer.MAX_VALUE);
        System.out.println(d);
    }
}

// myPow(3,-2)
//  1/myPow(3,2)

