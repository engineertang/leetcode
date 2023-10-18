package com.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// question 144, 中左右，Stack,
public class PreorderTraversal {
    //method 1: 遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList();
        if (root == null)
            return list;
        LinkedList<TreeNode> stack = new LinkedList();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if (treeNode.right != null) {  //此处有个trick，栈里先放右子节点，再放左子节点
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {  // 中左右
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);

            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /**      1
         *     4   3
         *   2
         */
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1, node4, node3);
        TreeNode node2 = new TreeNode(2);
        node4.left = node2;

        PreorderTraversal preorder = new PreorderTraversal();
        List list = preorder.preorderTraversal(node1);
        list.stream().forEach(o -> System.out.println(o.toString()));
    }

    // method 2: recurse 递归
    public List<Integer> recursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            list.addAll(recursion(root.left));
            list.addAll(recursion(root.right));
        }
        return list;
    }
}
