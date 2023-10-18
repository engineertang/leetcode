package com.binaryTree.binarySearchTree;

import com.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    List<Integer> result = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (stack.size() != 0) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);

            if (tmp.right != null) {
                TreeNode current = tmp.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }
    }

    public int next() {
        int cur = result.get(index++);
        return cur;
    }

    public boolean hasNext() {
        return index < result.size();
    }
}
