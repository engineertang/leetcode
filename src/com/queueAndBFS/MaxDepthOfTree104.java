package com.queueAndBFS;

import com.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfTree104 {
    // recursion
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // bfs breadth-first
    public int maxDepth2(TreeNode root) {
        if (root == null )
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while (queue.size() != 0){
            int levelSize = queue.size();

            while(levelSize > 0){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
                levelSize --;
            }

            count ++;
        }

        return count;
    }
}
