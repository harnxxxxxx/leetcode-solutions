import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a mapping from Roman numerals to integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0; // This will store the final integer value

        // Step 2: Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanMap.get(s.charAt(i)); // Get current value

            // Step 3: Check if the next character exists and if current < next
            if (i + 1 < s.length()) {
                int nextValue = romanMap.get(s.charAt(i + 1));
                if (currentValue < nextValue) {
                    // Subtractive case (e.g., IV, IX, XL, etc.)
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
            } else {
                // Last character (just add it)
                result += currentValue;
            }
        }

        return result;
    }
}