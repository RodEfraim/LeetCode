import java.util.ArrayList;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        String returnString = "";
        ArrayList<String> substrings = new ArrayList<String>();

        if(s.length() == 1)
            return s;
        else if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1))
                return s;
            else{
                returnString += s.charAt(0);
                return returnString;
            }
        }

        for(int lengthCount = 1; lengthCount <= s.length(); lengthCount++){
            for(int index = 0; index < lengthCount; index++){
                String ns = "";
                for(int count2 = index; count2 < lengthCount; count2++){
                    System.out.println(s.charAt(count2));
                    ns += s.charAt(count2);
                }
                // TRY capturing the palindrone without having to put them into an arrayList.
                substrings.add(ns);
            }
        }

        /*for(int lengthCount = 1; lengthCount <= s.length(); lengthCount++){
            for(int index = 0; index < lengthCount; index++){
                String ns = "";
                for(int count2 = index; count2 < lengthCount; count2++){
                    System.out.println(s.charAt(count2));
                    ns += s.charAt(count2);
                }
                substrings.add(ns);
            }
        }*/

        int largestPalindrome = 0;
        boolean isPalindrome = true;
        for(String substring : substrings){
            System.out.println("substring: " + substring);
            int reverseCount = substring.length() - 1;

            isPalindrome = isPalindrome(substring, true);

            if(isPalindrome == true && largestPalindrome < substring.length()){
                System.out.println("palindrome!");
                largestPalindrome = substring.length();
                returnString = substring;
            }
        }
        return returnString;
    }

    /**
     *
     * @param substring: The substring of the string.
     * @param isPalindrome: Always set to true.
     * @return the default true value, false if substring not a palindrome.
     */
    private static boolean isPalindrome(String substring, boolean isPalindrome){

        int reverseCount = substring.length() - 1;

        for(int count = 0; count < substring.length(); count++){
            System.out.println(substring.charAt(count) + " VS " + substring.charAt(reverseCount));
            if(substring.charAt(count) != substring.charAt(reverseCount))
                isPalindrome = false;
            reverseCount--;
        }

        return isPalindrome;
    }


    public static void main(String[] var0) {

        //String input = "101";
        //String input = "11011";
        //String input = "pooob";
        //String input = "poob";
        //String input = "poop";
        String input = "poopie";
        //String input = "babrd"
        //String input = "babbd";
        //String input = "adam";
        //String input = "aaaa";
        //String input = "cbbd";
        //String input = "babad";
        //String input = "abb";

        long startTime = System.currentTimeMillis();
        System.out.println("largestPalindrome: " + longestPalindrome(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
