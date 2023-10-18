package com.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest215 {
    // 堆排序
    public int findKthLargest2(int[] nums, int k) {
        // 1.堆化，生成一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        Integer res = null;
        // 边移除最大的顶点，边重新排序，重复k次
        while (k > 0) {
            res = maxHeap.poll();
            k--;
        }
        return res;
    }


    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - k)
                return nums[i];
        }
        return 0;
    }

}
