import java.util.Arrays;

/**
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Time Complexity
 * O(KlogK), where K = N + M. N = size of the first array, M = size of the second array.
 * As we sort the first array after it has stored all N + M elements.
 */
public class MergeSortedArrayEnhanced {

    public static void printArray(int[] nums){
        for(int count = 0; count < nums.length; count++){
            System.out.print(nums[count] + " ");
        }
        System.out.println();
    }

    public static void merge(int[] nums1, Integer m, int[] nums2, Integer n) {

        int nums1Length = m + n;
        System.out.println("nums1LengthL: " + nums1Length);
        int nums2Index = 0;

        if(m == 0){
            for(int count = 0; count < nums1Length; count++){
                nums1[count] = nums2[count];
            }
            printArray(nums1);
            return;
        }
        else if(n == 0){
            printArray(nums1);
            return;
        }

        for(int count = m; count < nums1Length; count++){
            nums1[count] = nums2[nums2Index++];
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~");
        printArray(nums1);
        Arrays.sort(nums1);
        printArray(nums1);
        System.out.println("~~~~~~~~~~~~~~~~~~~");
    }


    public static void main(String[] var0) {

//        int[] nums1 = new int[]{1,4,6,8,9,0, 0};
//        int[] nums2 = new int[]{2,7};
//        int var1 = 5;
//        int var2 = 2;

//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
//        int var1 = 3;
//        int var2 = 3;

//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{1};
//        int var1 = 0;
//        int var2 = 1;
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};
        int var1 = 3;
        int var2 = 3;
//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{4,5,6};
//        int var1 = 3;
//        int var2 = 3;

        long startTime = System.currentTimeMillis();
        merge(nums1, var1, nums2, var2);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

}
