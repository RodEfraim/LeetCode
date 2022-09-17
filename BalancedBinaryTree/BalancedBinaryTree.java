package BalancedBinaryTree;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        // return if the tree is empty
        if (root == null) {
            return true;
        }

        // create an empty stack and push the root node
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int heightBalance = 0;
        // count counts the number of nodes
        int count = 0;
        // countPush I believe counts the number of levels on the tree.
        int countPush = 0;
        boolean countPushed = false;
        int countPushRight = 0;
        int countPushLeft = 0;
        int nullChildCount = 0;

        int lh = 0;
        int rh = 0;

        // loop till stack is empty
        while (!stack.empty())
        {

            countPushed = false;
            System.out.println("countPush: " + countPush);
            // countPush I believe counts the number of levels on the tree.

            // pop a node from the stack and print it
            TreeNode curr = stack.pop();
            System.out.println("curr.val ~~~~~ " + curr.val + " ");

            lh = height(curr.left);
            rh = height(curr.right);
            System.out.println("lh: " + lh);
            System.out.println("rh: " + rh);
            System.out.println("Math.abs(lh - rh): " + Math.abs(lh - rh));

            if (Math.abs(lh - rh) > 1){
                return false;
            }

            // push the right child of the popped node into the stack
            if (curr.right != null) {
                stack.push(curr.right);
                if(countPushed == false){
                    countPush++;
                    countPushed = true;
                }
            }

            // push the left child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
                if(countPushed == false){
                    countPush++;
                    countPushed = true;
                }
            }
        }
        return true;
    }

    /* Given a binary tree, print its nodes in preorder using the recursive method.*/
    void printPreorder(TreeNode node)
    {
        if (node == null){
            System.out.println("pop... ");
            return;
        }

        /* first print data of node */
        //cout << node->data << " ";
        System.out.println(node.val);

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    static int height(TreeNode node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode();
        tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        //tree.left.left.left = new TreeNode(8);

        final long startTime = System.currentTimeMillis();
        System.out.println("isBalanced: " + isBalanced(tree));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

}