import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Space Complexity:
 * We are traversing the string once, hence the time complexity will be O(n).
 * We are using Stack to store characters of the string, hence the space complexity will be O(n).
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<String> stackParenthesis = new Stack<String>();

        for(int count = 0; count < s.length(); count++){
            if(s.charAt(count) == '(')
                stackParenthesis.push("(");
            else if(s.charAt(count) == '{')
                stackParenthesis.push("{");
            else if(s.charAt(count) == '[')
                stackParenthesis.push("[");

            if(s.charAt(count) == ')'){
                if(stackParenthesis.empty())
                    return false;
                if("(" != stackParenthesis.pop()){
                    return false;
                }
            }
            else if(s.charAt(count) == '}'){
                if(stackParenthesis.empty())
                    return false;
                if("{" != stackParenthesis.pop() ){
                    return false;
                }
            }
            else if(s.charAt(count) == ']'){
                if(stackParenthesis.empty())
                    return false;
                if("[" != stackParenthesis.pop()){
                    return false;
                }
            }
        }

        // Handle cases as when only the left-hand parenthesis are present like '[' or '{{'
        if(!stackParenthesis.empty())
            return false;

        return true;
    }

    public static void main(String[] var0) {

        //String input = "(())[]";
        //String input = "(())";
        //String input = "((])";
        //String input = "())";
        //String input = "()()[]{}";
        String input = "((([[[{{{}}}]]])))";

        long startTime = System.currentTimeMillis();
        System.out.println("isValid: " + isValid(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
