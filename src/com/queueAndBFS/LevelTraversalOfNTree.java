package com.queueAndBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Question : n叉树的层序遍历
public class LevelTraversalOfNTree {

    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while(queue.size() != 0){
            int curLevelNum = queue.size();

            List<Integer> curLevel = new LinkedList<>();
            // 每次只取单层的节点Node
            while (curLevelNum > 0){
                Node cur = queue.poll();
                curLevel.add(cur.val);
                curLevelNum --;

                if (cur.children != null){
                    List<Node> children = cur.children;
                    children.stream().forEach(node -> queue.add(node));
                }

            }

            result.add(curLevel);
        }

        return result;
    }
}
