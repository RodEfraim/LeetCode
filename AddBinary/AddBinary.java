package AddBinary;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public static String addBinary(String a, String b) {

        String reverseResult = "";
        String result = "";
        String buffer = "";

        int charDifference = Math.abs(a.length() - b.length());
        for(int count = 0; count < charDifference; count++)
            buffer += '0';

        if(a.length() < b.length()){
            buffer += a;
            reverseResult = reverseResult(b, buffer);
        }
        else{
            buffer += b;
            reverseResult = reverseResult(a, buffer);
        }

        //System.out.println("buffer: " + buffer);
        //System.out.println("reverseResult: " + reverseResult);
        for(int count = reverseResult.length() - 1; count >= 0; count--)
            result += reverseResult.charAt(count);

        return result;
    }

    public static String reverseResult(String largerString, String buffer){
        String reverseResult = "";
        boolean carry = false;

        for(int count = buffer.length() - 1; count >= 0; count--){
            if(carry == false){
                if(buffer.charAt(count) == '1' && buffer.charAt(count) == largerString.charAt(count)){
                    reverseResult += '0';
                    carry = true;
                }
                else if(buffer.charAt(count) == '0' && buffer.charAt(count) == largerString.charAt(count))
                    reverseResult += '0';
                else if(buffer.charAt(count) != largerString.charAt(count))
                    reverseResult += '1';
            }
            else{
                if(buffer.charAt(count) == '1' && buffer.charAt(count) == largerString.charAt(count)){
                    reverseResult += '1';
                    carry = true;
                }
                else if(buffer.charAt(count) == '0' && buffer.charAt(count) == largerString.charAt(count)){
                    reverseResult += '1';
                    carry = false;
                }
                else if(buffer.charAt(count) != largerString.charAt(count)){
                    reverseResult += '0';
                    carry = true;
                }
            }
        }

        if(carry)
            reverseResult += '1';
        return reverseResult;
    }

    public static void main(String[] var0) {
        String a = "11";
        String b = "1";

        long startTime = System.currentTimeMillis();
        System.out.println("Adding the following binaries together.");
        System.out.println(a + " + " + b + " = " + addBinary(a, b));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
