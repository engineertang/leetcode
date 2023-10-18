package com.binaryTree;

import java.util.*;

// question 145
public class PostorderTraversal {
    // method 1: recurse 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);
        }
        return list;
    }

    // method 2: linear 遍历
    /**
     * pre-order traversal is root-left-right, and post order is left-right-root.
     * modify the code for pre-order to make it root-right-left, and then reverse the output so that we can get left-right-root .
     * 1.Create an empty stack, Push root node to the stack.
     * 2.Do following while stack is not empty.
     * 2.1. pop an item from the stack and print it.
     * 2.2. push the left child of popped item to stack.
     * 2.3. push the right child of popped item to stack.
     * 3.reverse the ouput.
     */
    public static List<Integer> optimize(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();  //前后中 遍历结果
        Deque<TreeNode> stack = new ArrayDeque<>();  // 栈
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                result.addFirst(cur.val);  // Reverse the process of preorder
                cur = cur.right;             // Reverse the process of preorder
            } else  if (cur == null){
                TreeNode node = stack.pop();
                cur = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    // method 3: iteratvie 遍历
    public List<Integer> postorderTraversal3(TreeNode root) {// 中右左 -- 反转 -- 左中右
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        stack.push(root);
        while (stack.size() != 0){
            TreeNode cur = stack.pop();
            result.addFirst(cur.val);

            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
        }
        return result;
    }


    /**      1
     *     4   3
     *   2
     *   2 4 3 1
     */
}
