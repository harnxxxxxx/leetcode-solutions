import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();  // convert string to character array
            Arrays.sort(chars);              // sort the characters alphabetically
            String key = new String(chars);  // form a string from sorted characters

            if (!ans.containsKey(key)) {     // if the key (sorted string) is not in the map
                ans.put(key, new ArrayList<>());  // add key with empty list
            }
            ans.get(key).add(s);             // add the original string to that key's list
        }

        return new ArrayList<>(ans.values()); // return list of all grouped anagram lists
    }
}