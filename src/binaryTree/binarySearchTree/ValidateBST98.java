package binaryTree.binarySearchTree;

import binaryTree.TreeNode;

/**
 * issue98
 */
public class ValidateBST98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        ValidateBST98 test = new ValidateBST98();
        TreeNode treeNode = new TreeNode();
        test.isValidBST(treeNode);
    }
}
