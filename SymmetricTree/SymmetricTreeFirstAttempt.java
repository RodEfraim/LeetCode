package SymmetricTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeFirstAttempt {

    /**
     * Includes null tree nodes
     * @param root of the binary tree.
     * @return Arraylist of all the treenodes in level order.
     */
    public static ArrayList<TreeNode> levelOrderTraversal(TreeNode root) {

        ArrayList<TreeNode> treeNodeList = new ArrayList<TreeNode>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()){

            TreeNode currentNode = q.poll();

            treeNodeList.add(currentNode);

            if(currentNode != null) {

                System.out.println(currentNode.val);

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                } else {
                    q.add(null);
                    System.out.println("The left side of the this treenode is null!");
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                } else {
                    q.add(null);
                    System.out.println("The right side of the this treenode is null!");
                }
            }
        }

        return treeNodeList;
    }

    public static boolean listTraversal(ArrayList<TreeNode> treeNodeList){
        System.out.println("treenodeList.size(): " + treeNodeList.size());
        int power = 0;
        int sum = 0;
        int base = 2;
        ArrayList<Integer> exponentList = new ArrayList<Integer>();
        ArrayList<Integer> productList = new ArrayList<Integer>();

        for(int count = 0; count < treeNodeList.size(); count++){

            // Base to the power of count.
            double product = Math.pow(base, count);
            productList.add((int) product);
            sum += product;
            if(sum >= treeNodeList.size())
                break;
            //exponentList.add()
        }

        // TODO: Perhaps remove the last value of the productList since, the last level of the tree is all nulls.
        productList.remove(productList.size() - 1);

        for(int i : productList){
            System.out.println(i);
        }

        System.out.println("~~~~~~~~~~~~~~~~ Main loop ~~~~~~~~~~~~~~~~~~~");

        sum = 0;
        for(int count = 0; count < productList.size(); count++){

            sum += productList.get(count);

            //int endPointer = sum - 1;
            int endPointer = 1;

            // TODO: Have the loop end at sum / 2
            for(int innerCount = productList.get(count) - 1; innerCount < sum; innerCount++){

                // This conditional cuts the range of the iteration by half.
                if(innerCount > (sum - endPointer))
                    break;

                System.out.println("innerCount: " + innerCount);
                System.out.println("beginningPointer (" + innerCount + ")  VS  (" + (sum - endPointer) + ") endPointer.");

                if(treeNodeList.get(innerCount) != null)
                    System.out.print("treenodeList.get(innerCount).val  (" + treeNodeList.get(innerCount).val + ")  VS  ");
                else
                    System.out.print("treenodeList.get(innerCount)  (" + treeNodeList.get(innerCount) + ")  VS  ");

                if(treeNodeList.get(sum - endPointer) != null)
                    System.out.println("(" + treeNodeList.get(sum - endPointer).val + ")  treeNodeList.get(sum - endPointer).val");
                else
                    System.out.println("(" + treeNodeList.get(sum - endPointer) + ")  treeNodeList.get(sum - endPointer)");

                if(treeNodeList.get(innerCount) != null && treeNodeList.get(sum - endPointer) != null) {
                    if (treeNodeList.get(innerCount).val != treeNodeList.get(sum - endPointer).val) {
                        System.out.println("NOT EQUAL !");
                        return false;
                    }
                }
                else if(treeNodeList.get(innerCount) != null && treeNodeList.get(sum - endPointer) == null) {
                        System.out.println("NOT EQUAL !");
                        return false;
                }
                else if(treeNodeList.get(innerCount) == null && treeNodeList.get(sum - endPointer) != null) {
                        System.out.println("NOT EQUAL !");
                        return false;
                }

                endPointer++;
            }
            System.out.println("next iteration................");
        }

        return true;
    }

    public static void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + ", ");
    }

    public static void preorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + ", ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * The discovery of the inOrder output is that if the tree is symmetrical, the output order/array,
     * will have a symmetrical figure in which you can traverse with two pointers a pointers, one pointer starting
     * at the beginning and one starting at the end until they meet down the middle.
     * However this strategy does not work if the tree is contains null nodes.
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + ", ");
        inOrder(root.right);
    }


    public static void main(String[] args) {

        ArrayList<TreeNode> treeNodeList;// = new ArrayList<TreeNode>();

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
//        TreeNode tree1 = new TreeNode();
//        tree1 = new TreeNode(1);
//        tree1.left = new TreeNode(2);
//        tree1.right = new TreeNode(2);
//        tree1.left.left = new TreeNode(2);
//        //tree1.left.right = new TreeNode();
//        tree1.right.left = new TreeNode(2);

        treeNodeList = levelOrderTraversal(tree1);

        for (TreeNode i : treeNodeList){
            if(i != null)
                System.out.print(i.val + ", ");
            else
                System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("is symmetrical: " + listTraversal(treeNodeList));
    }

}
