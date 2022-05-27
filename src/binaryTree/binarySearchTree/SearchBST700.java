package binaryTree.binarySearchTree;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// similar to binary Search algorithm based on sorted array, here refer to binary tree. apply to reduce space between
// head and tail through comparision of middle and target
// BST is sub of binary Tree which the node is sorted
public class SearchBST700 {
    // binary search
    public TreeNode searchBST(TreeNode root, int target) {
        TreeNode cur = root;
        while (cur != null){
            if (cur.val ==  target){
                return cur;
            }else if (cur.val > target){
                // search in left subTree
                cur = cur.left;
            }else if (cur.val < target){
                // search in left subTree
                cur = cur.right;
            }
        }
        return cur;
    }

    // recursion
    public TreeNode searchBST2(TreeNode root, int target) {
        if(root == null){
            return null;
        }

        if (root.val ==  target){
            return root;
        }else if (root.val > target){
            // search in left subTree
            return searchBST2(root.left, target);
        }else{
            // search in left subTree
            return searchBST2(root.right, target);
        }
    }

    // 中序遍历
    public TreeNode searchBST3(TreeNode root, int target) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (stack.size() != 0) {
            TreeNode tmp = stack.pop();
            if (tmp.val == target){
                return tmp;
            }
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
        return null;
    }
}
