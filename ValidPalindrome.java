/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);
        s = s.toLowerCase();
        System.out.println(s);

        System.out.println("s.length: " + s.length());
        System.out.println("s.length divided by 2: " + s.length() / 2);
        int sLengthDivTwo = s.length() / 2;
        int backCounter = s.length() - 1;

        for(int count = 0; count < sLengthDivTwo; count++){
            if(s.charAt(count) != s.charAt(backCounter))
                return false;
            backCounter--;
        }
        return true;
    }

    public static void main(String[] var0) {
        String input = "A man, a plan, a canal: Panama";
        long startTime = System.currentTimeMillis();
        System.out.println("is valid palindrome: " + isPalindrome(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
