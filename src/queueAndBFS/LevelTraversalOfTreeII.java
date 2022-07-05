package queueAndBFS;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Question 102 二叉树的层序遍历
public class LevelTraversalOfTreeII {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while(queue.size() != 0){
            int curLevelNum = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            // 每次只取一层的个数
            while (curLevelNum > 0){
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);
                curLevelNum --;

                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }

            result.add(curLevel);
        }

        List<List<Integer>> result2 = new ArrayList<>();

        for (int i = result.size()-1; i >=0 ; i--) {
            result2.add(result.get(i));
        }
        return result2;
    }
}
