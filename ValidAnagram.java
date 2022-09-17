import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

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
        }

        Map<Character, Integer> t_hm = new HashMap<Character, Integer>();

        for (int count = 0; count < t.length(); count++) {

            if(!t_hm.containsKey(t.charAt(count)))
                t_hm.put(t.charAt(count), 1);
            else
                t_hm.put(t.charAt(count), t_hm.get(t.charAt(count)) + 1);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Character character : t_hm.keySet()) {
            System.out.println("char: " + character + " count of char: " + t_hm.get(character));
        }

        if(s_hm.equals(t_hm))
            return true;

        return false;
    }

    public static void main(String[] var0) {

        String input1 = "rat";
        String input2 = "car";

        long startTime = System.currentTimeMillis();
        System.out.println("isValid: " + isAnagram(input1, input2));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
