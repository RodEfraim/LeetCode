import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int longestSubstringWithoutRepeatingCharacters(String s){

        if(s.length() == 0)
            return 0;

        if(s.length() == 1)
            return 1;

        // Longest Substring without repeating characters.
        ArrayList<Character> longestSubstringWRC = new ArrayList<Character>();
        int longestSubstringCount = 0;
        boolean repeat = false;
        int innerCountIndex = 0;

        for(int count = 0; count < s.length(); count++){

            System.out.println(count+ ": " + s.charAt(count));

            if(count == 0)
                longestSubstringWRC.add(s.charAt(count));
            else{
                for(int innerCount = 0; innerCount < longestSubstringWRC.size(); innerCount++){

                    if(s.charAt(count) == longestSubstringWRC.get(innerCount)){
                        System.out.println("Character has repeated...");
                        repeat = true;
                        innerCountIndex = innerCount;
                        break;
                    }
                }

                if(repeat == false)
                    longestSubstringWRC.add(s.charAt(count));
                else{
                    repeat = false;
                    for(int countRemove = innerCountIndex; countRemove >= 0 ; countRemove--)
                        longestSubstringWRC.remove(countRemove);
                    longestSubstringWRC.add(s.charAt(count));
                }
            }

            System.out.println("longestSubstringWRC: " + longestSubstringWRC);

            if(longestSubstringCount < longestSubstringWRC.size()){
                longestSubstringCount = longestSubstringWRC.size();
            }
        }

        return longestSubstringCount;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        //String s = "dvdf";
        final long startTime = System.currentTimeMillis();
        System.out.println("Longest substring without repeating characters: " + longestSubstringWithoutRepeatingCharacters(s));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
