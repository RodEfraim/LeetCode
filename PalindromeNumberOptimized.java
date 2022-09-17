/**
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 *
 * Follow up: Could you solve it without converting the integer to a string? -- YES.
 */
public class PalindromeNumberOptimized {

    public static boolean isPalindrome(int x) {

        long reverseNum = 0;
        int xTracker = x;

        // If the number is negative return false, since you can't make a palindrome
        // with a negative number.
        if(x < 0)
            return false;

        int lengthOfX = (int) (Math.log10(x) + 1);
        System.out.println("lengthOfX: " + lengthOfX);
        double tenToThePowerOfLengthOfX = Math.pow(10, lengthOfX - 1);
        System.out.println("tenToThePowerOfLengthOfX: " + tenToThePowerOfLengthOfX);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");

        while (xTracker > 0) {

            // Prints the number in a reverse order.
            System.out.println(xTracker % 10);

            //testNum += multiplier * (xTracker % 10);
            reverseNum += tenToThePowerOfLengthOfX * (xTracker % 10);

            xTracker = xTracker / 10;
            //System.out.println("xTracker: " + xTracker);
            //System.out.println("reverseNum: " + reverseNum);
            //System.out.println("tenToThePowerOfLengthOfX: " + tenToThePowerOfLengthOfX);

            tenToThePowerOfLengthOfX = tenToThePowerOfLengthOfX / 10;
        }

        if(reverseNum == x)
            return true;

        return false;
    }

    public static void main(String[] var0) {

        //int input = -101;
        //int input = 1231;// 10101
        //int input = 101;
        int input = 2147483647;

        long startTime = System.currentTimeMillis();
        System.out.println("isPalindrome: " + isPalindrome(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
