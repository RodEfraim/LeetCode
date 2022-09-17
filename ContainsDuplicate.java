import java.util.*;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> newMap = new HashMap<>();
        boolean containsDuplicate = false;

        for(int count = 0; count < nums.length; count++){

            // Either containsKey or containsValue methods would work for this case.
            if(newMap.containsKey(nums[count])){
                containsDuplicate = true;
                return containsDuplicate;
            }else{
                newMap.put(nums[count], nums[count]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] intArray = {1,2,3,1};
        final long startTime = System.currentTimeMillis();

        System.out.println("containsDuplicate: " + containsDuplicate(intArray));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}