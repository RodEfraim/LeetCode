package BalancedBinaryTree;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTreeOptimized {

    public static boolean isBalanced(TreeNode root) {
        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (root == null)
            return true;

        System.out.println(root.val);

        /* Get the height of left and right sub trees */
        lh = height(root.left);
        rh = height(root.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    static int height(TreeNode node)
    {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode();
        tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        final long startTime = System.currentTimeMillis();
        System.out.println("isBalanced: " + isBalanced(tree));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
