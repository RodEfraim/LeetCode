package BalancedBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinraryTreeInorderTraversal {

    static ArrayList<Integer> integerList = new ArrayList<Integer>();

    static public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null){
            return integerList;
        }

        inorderTraversal(root.left);

        System.out.println(root.val);
        integerList.add(root.val);

        inorderTraversal(root.right);

        return integerList;
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode();
        tree = new TreeNode(1);
        //tree.left = new TreeNode(null);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);

        final long startTime = System.currentTimeMillis();
        System.out.println("inorder traversal: " + inorderTraversal(tree));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
