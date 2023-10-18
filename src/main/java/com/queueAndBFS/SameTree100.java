package com.queueAndBFS;

import com.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue  叫做广度优先遍历, 稍加改动，加一个每层的count，变成level order
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        if (p == null && null == q)
            return true;

        //if((p == null && null != q) || (p != null && null == q))
        if (p == null ^ null == q)
            return false;
        queue.add(p);
        queue2.add(q);
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.remove();
            TreeNode qNode = queue2.remove();
            if (pNode.val != qNode.val) {
                return false;
            }
            if (pNode.left == null ^ qNode.left == null) {
                return false;
            }
            if (pNode.right == null ^ qNode.right == null) {
                return false;
            }
            if (pNode.left != null && qNode.left != null) {
                queue.add(pNode.left);
                queue2.add(qNode.left);
            }
            if (pNode.right != null && qNode.right != null) {
                queue.add(pNode.right);
                queue2.add(qNode.right);
            }
        }

        return true;
    }

    // 第2种方法是使用递归
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        } else if (p != null && q != null && p.val != q.val) {
            return false;
        } else if (p == null && q == null) {
            return true;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.right = node2;

        SameTree100 question100 = new SameTree100();
        question100.isSameTree(node1, node1);
    }
}

