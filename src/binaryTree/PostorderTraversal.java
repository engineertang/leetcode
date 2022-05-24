package binaryTree;

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
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
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
