package ContainerWithMostWater;

import static java.lang.Math.abs;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int lPointer = 0;
        int rPointer = height.length - 1;

        if(height.length == 2)
            return 1 * getSmallestVal(height[lPointer], height[rPointer]);
        return comparePointers(height, lPointer, rPointer);
    }

    public static int getSmallestVal(int lPointerVal, int rPointerVal){
        if(lPointerVal < rPointerVal)
            return lPointerVal;
        else
            return rPointerVal;
    }

    /**
     *
     * @param height The array of ints.
     * @param lPointer The pointer that starts left of the array.
     * @param rPointer The pointer that starts right of the array.
     * @return boolean true if left pointer val is less than or equal to the right pointer val. False otherwise.
     */
    public static boolean getSmallestValDeep(int[] height, int lPointer, int rPointer){

        if(lPointer == rPointer)
            return true;

        if(height[lPointer] <= height[rPointer])
            return true;
        else
            return false;
    }

    public static int comparePointers(int[] height, int lPointer, int rPointer){

        int area = 0;
        int smallest;
        int maxArea = 0;

        if(height.length == 2)
            return 1 * getSmallestVal(height[lPointer], height[rPointer]);

        if(lPointer == rPointer)
            return maxArea;

        for(int count = 0; count < height.length; count++){

            if(lPointer == rPointer)
                return maxArea;

            smallest = getSmallestVal(height[lPointer], height[rPointer]);
            area = (rPointer - lPointer) * smallest;

            System.out.println("lPointer val " + height[lPointer] + " VS " + height[rPointer] + " rPointer val" );
            System.out.println("lPointer " + lPointer + " VS " + rPointer + " rPointer" );

            if(maxArea < area)
                maxArea = area;

            if(height[lPointer] < height[rPointer]){
                lPointer++;
            }
            else if(height[lPointer] > height[rPointer]){
                rPointer--;
            }
            else{

                // Do not perform the getSmallestValDeep function if the pointers are right next to each other.
                if(abs(lPointer - rPointer) == 1)
                    return maxArea;

                // If returns true then need to increment the lPointer.
                // If returns false then need to decrement the rPointer.
                boolean direction = getSmallestValDeep(height, lPointer + 1, rPointer - 1);
                if(direction)
                    lPointer++;
                else
                    rPointer--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] intArray = {1,8,6,2,5,4,8,3,7};
        //int[] intArray = {1,3,2,5,25,24,5};
        //int[] intArray = {1,2,1};
        //int[] intArray = {1,0,0,0,0,0,0,2,2};
        final long startTime = System.currentTimeMillis();
        System.out.println("maxArea: " + maxArea(intArray));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
