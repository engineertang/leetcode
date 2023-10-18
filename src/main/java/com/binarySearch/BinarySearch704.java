package com.binarySearch;

// Question 704
public class BinarySearch704 {
    public int search(int[] nums, int target) {
//        if(nums == null || nums.length == 0)
//            return -1;

        //设置一个指针middle，指向数组的中间；
        int from = 0, to = nums.length - 1, middle = (nums.length - 1) / 2;

        // from < middle < to -->>
        // { from = middle = to ||  from = middle < to }
        while (from <= to) {
            if (target == nums[middle]) {
                return middle;
            }
            if (target < nums[middle]) {
                to = middle - 1;
                middle = (from + to) / 2;
            } else if (target > nums[middle]) {
                from = middle + 1;
                middle = (from + to) / 2;
            }
        }

        return -1;

        // from < middle < to -->>
        // { from = middle = to ||  from = middle < to }
        /*while (nums[middle] != target) {
            if(from == to || (to - from == 1 && nums[to] != target)){
                return -1;
            }
            if (target < nums[middle] ) {
                to = middle -1  ;
                middle = (from + to) / 2;
            } else {
                from = middle + 1;
                middle = (from + to) / 2;
            }
        }
        return middle;*/
    }

    public static void main(String[] args) {
        BinarySearch704 binarySearch = new BinarySearch704();
        int[] array = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch.search(array, 2));
    }
}
