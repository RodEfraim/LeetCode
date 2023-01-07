package LengthOfLastWord;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int returnInt = 0;
        for(int count = s.length() - 1; count >= 0; count--){
            if(s.charAt(count) != ' ')
                returnInt++;
            else if(returnInt > 0 && s.charAt(count) == ' ')
                return returnInt;
        }
        return returnInt;
    }

    public static void main(String[] var0) {

        String input1 = "This is a test";
        String input2 = "Rodrigo";
        String input3 = "This is a test  ";

        long startTime = System.currentTimeMillis();
        System.out.println("isPalindrome: " + lengthOfLastWord(input1));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }


}
