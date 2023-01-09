package RemoveDuplicatesFromSortedArray;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
 * element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
 * k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place
 * with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {

        int previousInt = 0;
        Integer[] outputArray = new Integer[nums.length];

        for(int count = 1; count < nums.length; count++){
            System.out.println("nums[" + count + "]: " + nums[count]);
            System.out.println(nums[previousInt] + " VS " + nums[count]);
            if(nums[previousInt] == nums[count]){
                System.out.println("consecutive equal");
                // 101 because of the following condition; -100 <= nums[i] <= 100
                nums[count] = 101;
            }
            else
                previousInt = count;
        }

        System.out.println("~~~~~~ Original array with 101 place holders ~~~~~~");
        for(int i : nums){
            System.out.print(i + ", ");
        }

        System.out.println("\n~~~~~~ Output array ~~~~~~");
        int count = 0;
        for(int i : nums){
            if(i != 101){
                outputArray[count] = i;
                count++;
            }
        }

        int outputCount = 0;
        for(Integer i : outputArray){
            System.out.print(i + ", ");
            if(i == null)
                break;
            nums[outputCount] = i;
            outputCount++;
        }

        System.out.println("\noutputCount: " + outputCount);
        return outputCount;
    }


    public static void main(String[] args) {
        int[] input1 = {0,0,1,1,1,2,2,3,3,4};

        long startTime = System.currentTimeMillis();
        System.out.println("removeDuplicates: " + removeDuplicates(input1));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
