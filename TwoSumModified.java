import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumModified {

    /***
     * @param target
     * @param nums
     * @return array of the two numbers such that add up to target.
     */
    public static int[] TwoSumming(int target, int[] nums) {

        //System.out.println("target: " + target);
        //System.out.println("array: " + Arrays.toString(nums));

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        // Populate the hashmap with the Array's Integers as keys and
        // the Array's indexes as values.
        for(int count = 0; count < nums.length; count++){
            hm.put(nums[count], count);
        }

        // Print out the key-value pairs of the hashmap.
        /*for (Integer intkey: hm.keySet()) {
            int key = intkey;
            int value = hm.get(intkey);
            System.out.println(key + " " + value);
        }*/

        for(int count = 0; count < nums.length; count++){
            int x = target - nums[count];
            System.out.println("~~~~ " + x + " ~~~~");
            Integer potential_index = hm.get(x);

            if(potential_index != null && potential_index != count){
                System.out.println("index: " + potential_index);
                System.out.println("value of index: " + nums[potential_index]);
                int[] arrayToReturn = new int[]{count, potential_index};
                return arrayToReturn;
            }
        }
        return null;
    }

    public static void main(String[] var0) {
        int[] nums = new int[]{2, 4, 11, 3};
        byte target = 6;
        long var3 = System.currentTimeMillis();
        PrintStream var10000 = System.out;
        int[] var10001 = TwoSumming(target, nums);
        var10000.println("indices of the two numbers: " + Arrays.toString(var10001));
        long var5 = System.currentTimeMillis();
        System.out.println("Total execution time: " + (var5 - var3));
    }
}
