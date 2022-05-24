package binaryTree;

import java.util.*;

// question 94
// 中序遍历  左中右   用stack数据结构
// 有两种方法，一种是迭代循环，一种是递归
public class InorderTraversal {

/*     while(current != null)
           {stack.add(current);  current = cur.left; }

stage2:
      while(!stack.isEmpty){
            temp= stack.peek();
            if(temp.right==null){
                if(!list.contains(temp))
                     list.add(temp);
                stack.pop();
            }else if(temp.right!=null){
                list.add(temp)
                traversal(temp.right, Stack)
            }


        traversal(Node current, Stack stack){
            while(current !=null)
                {stack.add(current);
                current = cur.left; }
        }
      */

    // 迭代循环，从根节点开始
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        traversal(root, stack);  // 一次循环，把所有左子节点，全部放进stack栈

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.right == null) {
                list.add(temp.val);
                stack.pop();
            } else if (temp.right != null) {
                list.add(temp.val);
                stack.pop();
                traversal(temp.right, stack);
            }
        }
        return list;
    }

    public static void traversal(TreeNode current, Stack stack) {
        while (current != null) {
            stack.add(current);
            current = current.left;
        }
    }

    public static List<Integer> optimize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }

    // method 2: recurse 递归
    public List<Integer> recursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(recursion(root.left));
            list.add(root.val);
            list.addAll(recursion(root.right));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        List list = optimize(node1);
        list.stream().forEach(o -> System.out.println(o.toString()));
        // [1,3,2]
        /** 1
         *    2
         *  3
         */
    }

}
