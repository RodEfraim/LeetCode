package SameTree;

import java.util.ArrayList;
import java.util.List;

public class SameTreeModified {

    private static boolean same = true;

    public static boolean isSame(TreeNode tree1, TreeNode tree2){

        if(tree1 == null && tree2 == null)
            return true;
        if (tree1 == null || tree2 == null)
            return false;
        if(tree1.val != tree2.val)
            return false;
        System.out.println(tree1.val + " and " + tree2.val);
        //return isSame(tree1.right, tree2.right) && isSame(tree1.left, tree2.left);
        return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
    }

    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode();
        tree1 = new TreeNode(3);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);
        tree1.right.left = new TreeNode(15);
        tree1.right.right = new TreeNode(7);

        TreeNode tree2 = new TreeNode();
        tree2 = new TreeNode(3);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(20);
        tree2.right.left = new TreeNode(15);
        tree2.right.right = new TreeNode(7);

        final long startTime = System.currentTimeMillis();
        System.out.println("isSame: " + isSame(tree1, tree2));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
