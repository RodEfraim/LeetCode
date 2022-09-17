package BalancedBinaryTree;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int max = height(root);
        return max;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
