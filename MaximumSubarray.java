import java.util.*;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */
class MaximumSubarray {

    public static int findMax(int[] nums){

        if(nums.length == 1)
            return nums[0];

        int max = nums[0];
        int sum = 0;

        if(nums[0] <= 0)
            sum = 0;
        else
            sum = nums[0];

        for(int count = 1; count < nums.length; count++){

            sum += nums[count];

            if(max < sum)
                max = sum;

            // If the sum goes to zero or below, then reset the sum to 0.
            if(sum <= 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        //int[] intArray = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] intArray = {3, -2, -3, -3, 1, 3, 0};
        //int[] intArray = {-2, -1};
        //int[] intArray = {1};
        //int[] intArray = {5,4,-1,7,8};
        //int[] intArray = {-2, 1};
        //int[] intArray = {-2, -1};
        //int[] intArray = {8, -2, -4, -1, -8, 3, 8, 8, 3, 4, 2, -9, -1};
        int[] intArray = {8, -2, -4, -1, -8, 3, 8, 8, 3, 4, 2, -9, -1, -3, -6, 8, -3, 9}; // <-- This is the one failing...
        //int[] intArray = {8, -2, -4, -1, -8, 28, -9, -1};
        //int[] intArray = {9,0,-2,-2,-3,-4,0,1,-4,5,-8,7,-3,7,-6,-4,-7,-8};

        final long startTime = System.currentTimeMillis();
        System.out.println("Subarray Maximum Sum: " + findMax(intArray));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}