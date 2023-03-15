package PlusOne;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is
 * the ith digit of the integer. The digits are ordered from most significant to least significant
 * in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int newNum = 0;
        int carry = 0;
        Boolean plusOne = true;
        int[] carryArray;

        for(int count = digits.length - 1; count >= 0; count--){
            if(plusOne){
                newNum = 1 + digits[count];
                if(newNum == 10){
                    newNum = 0;
                    carry = 1;
                }
                digits[count] = newNum;
                plusOne = false;
            }
            else{
                if(carry != 0){
                    newNum = 1 + digits[count];
                    if(newNum == 10){
                        newNum = 0;
                        carry = 1;
                    }
                    else
                        carry = 0;
                    digits[count] = newNum;
                }
            }
        }

        if(carry == 1){
            carryArray = new int[digits.length + 1];
            carryArray[0] = carry;
            for(int count = 0 ; count < digits.length; count++)
                carryArray[count + 1] = digits[count];
            return carryArray;
        }
        return digits;
    }

    public static void main(String[] var0) {
        int[] input = new int[]{1,0,3,5,9};
        long startTime = System.currentTimeMillis();
        System.out.println("input array number + 1: ");
        for(int i : plusOne(input)){
            System.out.print(i);
        }
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
