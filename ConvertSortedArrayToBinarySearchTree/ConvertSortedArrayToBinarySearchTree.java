package ConvertSortedArrayToBinarySearchTree;

public class ConvertSortedArrayToBinarySearchTree {

    private static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0 || nums == null)
            return null;

        return constructBST(nums, 0, nums.length - 1);
    }

    private static TreeNode constructBST(int[] nums, int leftPointer, int rightPointer){
        if(leftPointer > rightPointer) {
            return null;
        }
        int mid = leftPointer + (rightPointer - leftPointer) / 2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBST(nums, leftPointer,mid - 1);
        current.right = constructBST(nums, mid + 1,rightPointer);
        return current;
    }

    public static void main(String[] var0) {

        int[] intArray = new int[]{-10,-3,0,5,9};

        System.out.println("Traverse through the original array.");
        for(int i : intArray){
            System.out.print(i + ", ");
        }
        System.out.println("\nnums.length: " + intArray.length);
        TreeNode tree1 = sortedArrayToBST(intArray);
    }
}
