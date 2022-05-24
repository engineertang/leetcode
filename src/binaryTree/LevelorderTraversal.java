package binaryTree;

import java.util.LinkedList;
import java.util.List;

// Question102   用queue的问题，广度优先算法BFS, 节点可能是null
public class LevelorderTraversal {
    public List<List<Integer>> levelOrder(TreeNode p) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> list = new LinkedList();

        queue.push(p);
        list.addLast(p.val);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();

            if (treeNode.left != null) {
                queue.push(treeNode.left);
                list.addLast(treeNode.left.val);
            }
            if (treeNode.right != null) {
                queue.push(treeNode.right);
                list.addLast(treeNode.right.val);
            }
        }

        return null;
    }
}
