import java.util.*;
import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
class TwoSum {

    /**
     * TODO: Optimize the function so it does not have O(n^2) runtime.
     *
     * @param target
     * @param nums
     * @return array of the two numbers such that add up to target.
     */
    public static int[] TwoSumming(int target, int[] nums) {

        System.out.println("target: " + target);
        System.out.println("array: " + Arrays.toString(nums));

        int firstIndex = 0;
        int secondIndex = 0;

        for(int count1 = 0; count1 < nums.length; count1++){

            System.out.println("outer loop value: " + nums[count1]);
            for(int count2 = count1 + 1; count2 < nums.length; count2++){

                System.out.println("inner loop value: " + nums[count2]);
                if((nums[count1] + nums[count2]) == target){
                    firstIndex = count1;
                    secondIndex = count2;
                    break;
                }
            }
        }

        int[] indexSum = {firstIndex, secondIndex};
        Arrays.sort(indexSum);
        return indexSum;
    }

    public static void main(String[] args) {

//        int[] intArray = {2,7,11,15};
//        int target = 9;
//        int[] intArray = {3,2,4};
//        int target = 6;
//        int[] intArray = {3,3};
//        int target = 6;
        int[] intArray = {2,4,11,3};
        int target = 6;

        final long startTime = System.currentTimeMillis();
        System.out.println("indices of the two numbers: " + Arrays.toString(TwoSumming(target, intArray)));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}