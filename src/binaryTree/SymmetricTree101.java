package binaryTree;

public class SymmetricTree101 {
    // 递归
    public boolean isSymmetric(TreeNode root) {
        /*
        root.left = root.right;
        root.left.left = root.right.right;
        root.left.right == root.right.left
        */

        return isSymmetric(root.left, root.right);
    }


    public boolean isSymmetric(TreeNode left, TreeNode right) {
        //异或 base case
        if (left == null && right == null) {
            return true;
        } else if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        } else if (left != null && right != null && left.val != right.val) {
            return false;
        }

        //递推公式
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
