package Arrays.Hashing;

import java.util.HashSet;
import java.util.Set;

public class Count_the_Number_of_Consistent_Strings {
    /*
     * Use a Set for fast lookup:
     * Convert the allowed string into a Set so you can quickly check if a character
     * is allowed.
     * 
     * Iterate through each word in words:
     * 
     * For each word, check if every character in the word is present in the allowed
     * set.
     * 
     * If so, increment a count variable.
     * 
     * Return the count of consistent words.
     */
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        return count;
    }
}
