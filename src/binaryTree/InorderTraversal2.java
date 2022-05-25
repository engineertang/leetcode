package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 94 and 144
public class InorderTraversal2 {
    // 数据结构Deque 可作为Queue and Stack
    public List<Integer> inorderTraversal(TreeNode root) {
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
            if (tmp.right != null)  {
                TreeNode current = tmp.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }

        }
        return result;
    }
}
