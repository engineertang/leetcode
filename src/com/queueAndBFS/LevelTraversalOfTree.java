package com.queueAndBFS;

import com.binaryTree.TreeNode;

import java.util.*;

// Question 102 二叉树的层序遍历
public class LevelTraversalOfTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();


        List<Integer> curLevel = new LinkedList<>();;
        int curLevelNum = 1;
        int nextLevelNum = 0;
        int curLevelIndex = 0;

        while(queue.size() != 0){

            if(curLevelIndex == curLevelNum){
                result.add(curLevel);
                curLevelIndex = 0;
                curLevel = new LinkedList<>();
                curLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
            TreeNode cur = queue.poll();
            curLevel.add(cur.val);
            curLevelIndex ++;

            if (cur.left != null){
                queue.add(cur.left);
                nextLevelNum++;
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextLevelNum++;
            }
        }
        if (curLevel.size()!= 0)
            result.add(curLevel);
        return result;
    }
}
