/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index.
 * Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {

    /**
     * Binary search only works on sorted array
     * @param nums: sorted array of integers
     * @param target:  target value to search for in the sorted array.
     * @return The index of where target belongs on the array. Return -1 otherwise.
     */
    public static int binarySearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            System.out.println("mid: " + mid);
            System.out.println("nums[mid]: " + nums[mid]);
            if (target < nums[mid])
                high = mid - 1;
            else if (target == nums[mid])
                return mid;
            else
                low = mid + 1;
            System.out.println("high: " + high);
            System.out.println("low: " + low);
            System.out.println("l~~~~~~~~~~~~~~~~~~~~");
        }
        return - 1;
    }

    public static void main(String[] var0) {
        int[] input = new int[]{-1,0,3,5,9,12};
        //int[] input = new int[]{10,20,25,15,3,7,5,10,30,2,15,60,30};
        int target = 9;
        long startTime = System.currentTimeMillis();
        System.out.println("binary search target's index location: " + binarySearch(input, target));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
