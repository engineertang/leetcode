package com.queueAndBFS;

import com.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Question 102 二叉树的层序遍历
public class LevelTraversalOfTreePrint {

    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Integer> result = new ArrayList<>();

        while(queue.size() != 0){
            int curLevelNum = queue.size();
            //List<Integer> curLevel = new LinkedList<>();
            // 每次只取一层的个数
            while (curLevelNum > 0){
                TreeNode cur = queue.poll();
                result.add(cur.val);
                curLevelNum --;

                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }

            //result.add(curLevel);
        }
        return result.stream().mapToInt(value -> value.intValue()).toArray();
    }
}
