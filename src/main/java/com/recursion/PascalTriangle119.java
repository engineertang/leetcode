package com.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/17.
 * Questtion119
 */
public class PascalTriangle119 {
    //dynamic programming
    //自更新： list从左侧加入一个1，然后更新index为1到倒数第2个数，此处循环j是迭代的实现，每次会从一行一行往下迭代更新
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;
        //第n行有n+1个数，List.size=n+1
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            //自更新： list从左侧加入一个1，然后更新index为1到倒数第2个数，此处循环j是迭代的实现，每次会从一行一行往下迭代更新
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    // 递归
    // 第rowIndex有rowIndex+1个数
    // f(rowIndex, j) = f(rowIndex-1, j-1) + f(rowIndex-1, j)
    // f(0,0) = 1
    // f(1,0) = 1 && f(1,1) =1
    // 1.. f(n-1, x-1) f(n-1, x)
    // f(n, 0) =1  ... f(n, x) ...   f(n, n) =1
    // 优化缓存Map，使用二维数组
    //HashMap<String, Integer> map = new HashMap<>();
    int[][] cache = null;

    public List<Integer> recursion(int rowIndex) {
        cache = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(recurse(rowIndex, i));
        }
        return result;
    }


    public Integer recurse(int rowIndex, int columnIndex) {
        //String key = rowIndex + " + " +columnIndex;
        /*if (map.containsKey(key)){
            return map.get(key);
        }*/
        if (cache[rowIndex][columnIndex] != 0) {
            return cache[rowIndex][columnIndex];
        }
        if (columnIndex == 0 || columnIndex == rowIndex) {
            //map.put(key, 1);
            cache[rowIndex][columnIndex] = 1;
            return 1;
        } else {
            Integer value = recurse(rowIndex - 1, columnIndex - 1)
                    + recurse(rowIndex - 1, columnIndex);
            //map.put(key, value );
            cache[rowIndex][columnIndex] = value;
            return value;
        }
    }

    public static void main(String[] args) {
        PascalTriangle119 pascalTriangle = new PascalTriangle119();
        pascalTriangle.getRow(30).stream()
                .forEach(integer -> System.out.printf(integer + "  ")
                );
    }
}
