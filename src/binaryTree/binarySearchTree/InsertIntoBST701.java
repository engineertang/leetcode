package binaryTree.binarySearchTree;

import binaryTree.TreeNode;

public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int target) {
        if(root == null)
            return new TreeNode(target);
        // 先搜索，找到target 在哪个范围，叶子节点；
        // binary search 二分查找算法
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null ){
            pre = cur;
            if (cur.val > target){
                // search in left subTree
                cur = cur.left;
            }else if (cur.val < target){
                // search in left subTree
                cur = cur.right;
            }
        }
        if(pre.val > target){
            pre.left = new TreeNode(target);
        }else
            pre.right = new TreeNode(target);

        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int target) {
        if (root == null)
            return new TreeNode(target);
        // 先搜索，找到target 在哪个范围，叶子节点；
        // binary search 二分查找算法
        TreeNode cur = root;
        while (cur.left != null || cur.right != null) {
            if (cur.val > target) {
                // search in left subTree
                if(cur.left != null){
                    cur = cur.left;
                }else {
                    cur.left = new TreeNode(target);
                }
            } else if (cur.val < target) {
                if(cur.right != null){
                    // search in left subTree
                    cur = cur.right;
                }else {// 右子节点为空，怎么办呢。
                    cur.right = new TreeNode(target);
                }

            }
        }

        return root;
    }
}
