/**
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 */
public class PalindromeNumberEnhanced {

    public static boolean isPalindrome(int x) {

        String stringInt = String.valueOf(x);
        int reverseIndex = stringInt.length() - 1;

        // If the number is negative return false, since you can't make a palindrome
        // with a negative number.
        if(x < 0)
            return false;

        for(int count = 0; count < stringInt.length() / 2; count++) {
            if(stringInt.charAt(count) != stringInt.charAt(reverseIndex--))
                return false;
        }

        System.out.println("stringInt: " + stringInt);

        return true;
    }

    public static void main(String[] var0) {

        //int input = -101;
        //int input = 1010; 10101
        int input = 101;

        long startTime = System.currentTimeMillis();
        System.out.println("isPalindrome: " + isPalindrome(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
