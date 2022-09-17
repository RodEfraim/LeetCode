import java.util.Arrays;

public class ValidAnagramOptimized {
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] var0) {

        //String input1 = "rat";
        //String input2 = "car";
        String input1 = "hello";
        String input2 = "ehllo";

        long startTime = System.currentTimeMillis();
        System.out.println("isValid: " + isAnagram(input1, input2));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
