package com.binaryTree;

public class sortedArrayToBST108 {
    //递归，每次取中间的数，左边的数做左节点，右边的数是右节点，左右最多差1
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int head, int tail) {
        //base case
        // head + 2 = tail  || head + 1 = tail, head=middle<tail
        if(head == tail) {
            return new TreeNode(nums[head]);
        }
        if(head > tail){
            return null;
        }

        int middle = head + (tail - head) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        // [0, middle) left (middle, tail] right
        TreeNode left = sortedArrayToBST(nums, head, middle - 1);
        TreeNode right = sortedArrayToBST(nums, middle + 1, tail);

        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }
}