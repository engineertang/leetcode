package com.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidTree {
    // recursion递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // root.val (min, max)
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        boolean result = root.val > min && root.val < max;
        if (!result)
            return result;

/*        if (root.left == null && root.right == null) {
            return root.val > min && root.val < max;
        } else if (root.left == null && root.right != null) {
            return isValidBST(root.right, root.val, max);
        } else if (root.left != null && root.right == null) {
            return isValidBST(root.left, min, root.val);
        } else if (root.left != null && root.right != null) {*/

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // 中序遍历，迭代非递归
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (stack.size() != 0) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);

            /*if (tmp.right == null) {
            } else */
            if (tmp.right != null) {
                TreeNode current = tmp.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }

        for (int i = 1; i < result.size(); i++) {// 判断list是单调递增
            if (result.get(i) <= result.get(i - 1))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        ValidTree validTree = new ValidTree();
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

//        treeNode2.left = treeNode1;
//        treeNode2.right = treeNode3;

        System.out.println(validTree.isValidBST(treeNode2));
    }

}
