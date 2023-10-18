package com.recursion;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        /**
         * 求二叉树的最大深度
         * recurse relation
         * f(treeNode)
         *     f(treeNode.left)
         *     f(treeNode.right)
         *     Math.max(f(treeNode.left), f(treeNode.right)) + 1
         *
         * bottom case
         *           f(left)
         *                left == null  then height ==0
         *
         * binary search tree是二叉搜索树
         *
         */
        if (root == null) {
            return 0;
        }
        int rootHeight = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return rootHeight;
    }

    public int minDepth(TreeNode root) {
        /**
         * 求二叉树的最小深度
         *
         * [2,null,3,null,4,null,5,null,6]
         *     2
         *   9   3
         *      4
         *    5
         *  6
         *
         */
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        if (root.left != null && root.right == null)
            return minDepth(root.left) + 1;
        //if(root.left != null && root.right != null)
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    //     深度优先算法 用stack栈， 广度优先用队列

    /**
     * 判断叶子节点，leafNode. left,right =null   &&  leafNode != root
     *
     * @param root
     * @return
     */
    public int minDepthBFS(TreeNode root) {

        return 0;
    }
}
