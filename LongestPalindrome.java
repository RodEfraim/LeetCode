import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 * The rule would be for every char count to have an even count, and then accept only one char
 * that has an odd count, but make sure that this odd count is the largest odd count in the map.
 * For the remainder of chars that have an odd count, subtract it by 1 to convert their count to even
 * and thus remain with a valid palindrome.
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s){

        int largestOddChar = 0;
        int countLongestPalindrome = 0;
        ArrayList<Integer> charOddCountList = new ArrayList<Integer>();
        boolean largestOddUsed = false;
        boolean moreThanOne = false;

        // For every letter you encounter in the word, make a new key for the map.
        Map<Character, Integer> s_hm = new HashMap<Character, Integer>();

        for(int count = 0; count < s.length(); count++) {
            if(!s_hm.containsKey(s.charAt(count)))
                s_hm.put(s.charAt(count), 1);
            else
                s_hm.put(s.charAt(count), s_hm.get(s.charAt(count)) + 1);
        }

        for (Character character : s_hm.keySet()) {
            System.out.println("char: " + character + " count of char: " + s_hm.get(character));
            int charCount = s_hm.get(character);

            if(charCount % 2 != 0){
                charOddCountList.add(charCount);
                if(largestOddChar < charCount) {
                    largestOddChar = charCount;
                    moreThanOne = false;
                }
                else if(largestOddChar == charCount)
                        moreThanOne = true;
            }
            else {
                // Adding the count of the chars that have an even count.
                countLongestPalindrome += charCount;
            }
        }

        // Adding the count of the chars that have an odd count.
        // The odd char with the highest count should be added without subtracting by 1.
        // The rest odd char counts should be subtracted by 1 so the number remains even.
        for(int count = 0; count < charOddCountList.size(); count++){
            if(moreThanOne == false){
                if(charOddCountList.get(count) == largestOddChar)
                    countLongestPalindrome += charOddCountList.get(count);
                else
                    countLongestPalindrome += charOddCountList.get(count) - 1;
            }
            else{
                if(charOddCountList.get(count) == largestOddChar){
                    if(largestOddUsed == false) {
                        countLongestPalindrome += charOddCountList.get(count);
                        largestOddUsed = true;
                    }
                    else
                        countLongestPalindrome += charOddCountList.get(count) - 1;
                }
                else
                    countLongestPalindrome += charOddCountList.get(count) - 1;
            }
        }

        System.out.println("largestOddChar: " + largestOddChar);
        return countLongestPalindrome;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        final long startTime = System.currentTimeMillis();
        System.out.println("longestPalindrome: " + longestPalindrome(s));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}