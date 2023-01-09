package LongestCommonPrefix;

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String minPrefix = "";
        int charMatchMinimumCount = 201;

        if(strs.length == 0)
            return minPrefix;
        else if(strs.length == 1)
            return strs[0];

        for(int outerCount = 1; outerCount < strs.length; outerCount++){

            // Used to determine which string is shorter. So that the inner loop's max number of iteration
            // is based on the length of smallerString variable.
            String smallerString;
            String prefix = "";
            int charMatchCount = 0;

            System.out.println("strs[outerCount]: " + strs[outerCount]);
            // Compares the array's first string length to the rest of the other strings' length.
            if(strs[0].length()  <= strs[outerCount].length())
                smallerString = strs[0];
            else
                smallerString = strs[outerCount];

            for (int innerCount = 0; innerCount < smallerString.length(); innerCount++) {
                System.out.println(strs[outerCount].charAt(innerCount));
                // Always compare the first string on the array to the rest of the strings.
                if (strs[0].charAt(innerCount) == strs[outerCount].charAt(innerCount)) {
                    prefix += strs[outerCount].charAt(innerCount);
                    System.out.println(" match! ");
                    charMatchCount++;
                } else
                    break;
            }

            // If prefix is "", then this means that there is no common prefix between the first string
            // and the nth string, so return that there is no common string.
            if (prefix == "")
                return "";
            System.out.println("prefix: " + prefix);
            if (charMatchMinimumCount > charMatchCount) {
                charMatchMinimumCount = charMatchCount;
                minPrefix = prefix;
            }
        }
        return minPrefix;
    }

    public static void main(String[] args) {
        String[] input1 = {"flower","flow","flight"};
        String[] input2 = {"dog","racecar","car"};
        String[] input3 = {"dog"};
        String[] input4 = {"aaa","aa","aaa"};

        long startTime = System.currentTimeMillis();
        System.out.println("longestCommonPrefix: " + longestCommonPrefix(input1));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
