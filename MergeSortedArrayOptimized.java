/**
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
 * O(N + M). N = size of the first array, M = size of the second array. As we traverse both the arrays once.
 */
public class MergeSortedArrayOptimized {

    public static void printArray(int[] nums){
        for(int count = 0; count < nums.length; count++){
            System.out.print(nums[count] + " ");
        }
        System.out.println();
    }

    public static void merge(int[] nums1, Integer m, int[] nums2, Integer n) {

        int nums1Length = m + n;
        System.out.println("nums1LengthL: " + nums1Length);
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int nums1TotalIndex = (m + n) - 1;

        while(nums1Index >= 0 && nums2Index >= 0){
            if(nums1[nums1Index] < nums2[nums2Index]){
                nums1[nums1TotalIndex] = nums2[nums2Index];
                nums2Index--; // Decrement the pointer for the nums2
            }
            else if(nums1[nums1Index] >= nums2[nums2Index]){
                nums1[nums1TotalIndex] = nums1[nums1Index];
                nums1Index--; // Decrement the pointer for the nums1
            }

            nums1TotalIndex--;
        }

        for(int count = nums1Index; count >= 0; count--){
            nums1[nums1TotalIndex] = nums1[count];
            nums1TotalIndex--;
        }

        for(int count = nums2Index; count >= 0; count--){
            nums1[nums1TotalIndex] = nums2[count];
            nums1TotalIndex--;
        }

        printArray(nums1);
    }

    public static void main(String[] var0) {

        int[] nums1 = new int[]{1,4,6,8,9,0, 0};
        int[] nums2 = new int[]{2,7};
        int var1 = 5;
        int var2 = 2;

//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
//        int var1 = 3;
//        int var2 = 3;

//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{1};
//        int var1 = 0;
//        int var2 = 1;
//        int[] nums1 = new int[]{4,5,6,0,0,0};
//        int[] nums2 = new int[]{1,2,3};
//        int var1 = 3;
//        int var2 = 3;
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
