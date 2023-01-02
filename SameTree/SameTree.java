package SameTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * This solution works, but it does not take into account when a null Tree node value is passed.
 * Also, the solution is not as fast since it processes all the nodes before giving a final result,
 * as opposed to returning earlier when nodes do not match up.
 */
public class SameTree {

    public static boolean isSame(TreeNode tree1, TreeNode tree2){

        ArrayList<Integer> integerList1 = new ArrayList<Integer>();
        ArrayList<Integer> integerList2 = new ArrayList<Integer>();

        inorderTraversal(tree1, integerList1);
        inorderTraversal(tree2, integerList2);

        System.out.println("~~~~~~ integerList1:");
        for(Integer i : integerList1){
            System.out.println(i);
        }

        System.out.println("~~~~~~ integerList2:");
        for(Integer i : integerList2){
            System.out.println(i);
        }

        if(integerList1.equals(integerList2))
            return true;

        return false;
    }

    static private List<Integer> inorderTraversal(TreeNode root, ArrayList<Integer> treeArray) {

        if (root == null)
            return treeArray;

        inorderTraversal(root.left, treeArray);
        System.out.println(root.val);
        if(root.equals(null)) {
            System.out.println("This node is null...");
        }
        treeArray.add(root.val);
        inorderTraversal(root.right, treeArray);

        return treeArray;
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

        // It will not catch the following test case.
//        TreeNode tree1 = new TreeNode();
//        tree1 = new TreeNode(1);
//        tree1.left = new TreeNode(1);
//
//        TreeNode tree2 = new TreeNode();
//        tree2 = new TreeNode(1);
//        tree2.left = null;
//        tree2.right = new TreeNode(1);

        final long startTime = System.currentTimeMillis();
        System.out.println("isSame: " + isSame(tree1, tree2));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
