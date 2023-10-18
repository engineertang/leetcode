package com.array;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        // 先排序，后比较，前一个数是否和后一个相等
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    /**Question 219. Contains Duplicate II
    *       linear loop,  save a changing temp queue which arrange is [cur, cur+k] around current index cur;
    *       Queue<Integer> queue
    *    3  5  6  8  2  1  0
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i]))
                return true;
        }
        ;

        return false;
    }

    /**
     * 有数据量大时，时间超时
      */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; (i <= k) && (i < nums.length); i++) {
            queue.add(nums[i]);
        }

        boolean single = containsDuplicate(queue.stream().mapToInt(num -> num).toArray());
        if (single)
            return true;

        int i = 0;
        while ((i < nums.length) && (i + k < nums.length - 1)) {
            i++;
            queue.remove();
            single = queue.contains(nums[i + k]);
            queue.add(nums[i + k]);
            //containsDuplicate(queue.stream().mapToInt(num -> num).toArray());
            if (single)
                return true;
        }
        ;

        return false;
    }

    public static void main(String[] args) {
        String sValue = null;
        try (InputStream input = new FileInputStream("src/array/arrayText.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            sValue = prop.getProperty("nums");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strings = sValue.split(",");
        //int[] array = Arrays.stream(strings).mapToInt(value -> Integer.parseInt(value)).toArray();
        int[] array = {1, 2, 3, 1, 2, 3};

        ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
        System.out.println(containsDuplicate217.containsNearbyDuplicate(array, 2));
    }
}
