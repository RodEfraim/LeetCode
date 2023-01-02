package SymmetricTree;

import java.util.ArrayList;

public class SymmetricTree {
    private static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == right;

        if(left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right);
    }

    public static void main(String[] args) {

        // SYMMETRIC TREE
        TreeNode tree1 = new TreeNode();
        tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right.left = new TreeNode(4);
        tree1.right.right = new TreeNode(3);

        // NOT SYMMETRIC TREE
        TreeNode tree2 = new TreeNode();
        tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(2);
        tree2.left.left = new TreeNode(2);
        //tree1.left.right = new TreeNode();
        tree2.right.left = new TreeNode(2);


        System.out.println("is symmetrical: " + isSymmetric(tree1));
        System.out.println("is symmetrical: " + isSymmetric(tree2));

    }

}
