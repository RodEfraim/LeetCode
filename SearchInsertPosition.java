/**
 * Given a sorted array of distinct integers and a target value, return the index
 * if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        for(int count = 0; count < nums.length; count++){
            //System.out.println(nums[count]);

            if(nums[count] == target)
                return count;

            if(target < nums[count])
                return count;
        }

        // If target is not found, return length of the array as the index of the target.
        return nums.length;
    }

    public static void main(String[] args) {

        int[] intArray = {1,2,4,11};
        int target = 4;

        final long startTime = System.currentTimeMillis();
        System.out.println("searchInsert: " + searchInsert(intArray, target));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
