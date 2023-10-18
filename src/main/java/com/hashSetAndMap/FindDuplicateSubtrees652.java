package com.hashSetAndMap;

import com.recursion.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees652 {
    HashMap<String, Integer> dic = new HashMap<>();      // 缓存dic

    List<TreeNode> result = new ArrayList<>();
    //HashMap<String, TreeNode> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getKey(root);
        return result;
    }

    // recursion 迭代，中序遍历
    public String getKey(TreeNode cur) {
        if (cur == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cur.val);
        if (null != cur.left || null != cur.right) {
            stringBuilder.append("(").append(getKey(cur.left)).append(getKey(cur.right)).append(")");
        }
        dic.put(stringBuilder.toString(), dic.getOrDefault(stringBuilder.toString(), 0) + 1);
        if (dic.get(stringBuilder.toString()) == 2) {
            result.add(cur);
        }
        return stringBuilder.toString();
    }


}
