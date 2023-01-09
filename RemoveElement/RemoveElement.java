package RemoveElement;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order
 * of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the
 * first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with
 * O(1) extra memory.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {

        Integer[] outputArray = new Integer[nums.length];
        System.out.println("val: " + val);
        int count = 0;
        for(int i : nums){
            if(i != val){
                outputArray[count] = i;
                count++;
            }
        }

        System.out.println("\n~~~~~~ Output array ~~~~~~");
        int outputCount = 0;
        for(Integer i : outputArray){
            if(i == null)
                break;
            System.out.print(i + ", ");
            nums[outputCount] = i;
            outputCount++;
        }

        System.out.println("\noutputCount: " + outputCount);
        return outputCount;
    }

    public static void main(String[] args) {
        int[] arrayInput = {0,1,2,2,3,0,4,2};
        int val = 2;

        long startTime = System.currentTimeMillis();
        System.out.println("removeDuplicates: " + removeElement(arrayInput, val));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
