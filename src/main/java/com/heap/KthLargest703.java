package com.heap;

import java.util.PriorityQueue;

public class KthLargest703 {
    public int kth;
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest703(int k, int[] nums) {
        kth = k;
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > kth)
            minHeap.poll();

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 8, 2};
        KthLargest703 obj = new KthLargest703(3, array);

        int param_1 = obj.add(3);
        System.out.println(param_1);
        param_1 = obj.add(5);
        System.out.println(param_1);
        param_1 = obj.add(10);
        System.out.println(param_1);

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
