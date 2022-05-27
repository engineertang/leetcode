package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Question102   queue，层序遍历
public class LevelorderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode p) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<>();
        if (p == null){
            return result;
        }

        queue.add(p);
        while (!queue.isEmpty()) {
            // queue里只会保留当前一层的节点
            int levelCount = queue.size();
            LinkedList<Integer> list = new LinkedList();

            while(levelCount > 0){
                TreeNode current = queue.remove();
                list.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

                levelCount --;
            }

            result.add(list);
        }

        return result;
    }
}
