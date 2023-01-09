package FindTheIndexOfTheFirstOccurenceInAString;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {

        int recordIndex = 0;
        boolean explore = false;

        if(needle.length() > haystack.length())
            return -1;

        for(int count = 0; count < haystack.length(); count++){
            System.out.println(haystack.charAt(count));
            if(haystack.charAt(count) == needle.charAt(0)){
                recordIndex = count;
                explore = true;
                // If the current index count + the needle.length exceeds the array limit of haystack string then exit.
                if(count + needle.length() > haystack.length())
                    break;
            }
            if(explore == true){
                for(int innerCount = 0; innerCount < needle.length(); innerCount++){
                    System.out.println(needle.charAt(innerCount) + " VS " + haystack.charAt(count + innerCount));
                    if(needle.charAt(innerCount) == haystack.charAt(count + innerCount)){
                        if(innerCount == needle.length() - 1)
                            return recordIndex;
                    }
                    else
                        break;
                }
            }
            explore = false;
        }
        return -1;
    }

    public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("needle: " + needle);
        System.out.println("needle.length(): " + needle.length());
        System.out.println("haystack: " + haystack);
        System.out.println("haystack.length(): " + haystack.length());
        System.out.println("~~~~~~~~~~~~~~~~~");

        long startTime = System.currentTimeMillis();
        System.out.println("removeDuplicates: " + strStr(haystack, needle));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
