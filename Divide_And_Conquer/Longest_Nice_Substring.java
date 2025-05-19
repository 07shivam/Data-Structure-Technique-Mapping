package Divide_And_Conquer;

import java.util.HashSet;
import java.util.Set;

/*
    1. If the string is nice, return it.
    2. If not, find the first bad character (one that doesn't have both cases).
    3. Split the string on that character, and recursively solve both halves.
    4. Return the longer result from the two halves.
*/

public class Longest_Nice_Substring {
    public String longestNiceSubstring(String s) {
        // Base case: if string length is less than 2, it can never be nice
        if(s.length() < 2 )
        return "";

        // Use a Set to keep track of characters in the current string
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray())
        {
            set.add(c);
        }

          // Find a "bad character"
        for(int i=0; i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(set.contains(Character.toLowerCase(ch)) && set.contains(Character.toUpperCase(ch)))
            continue;

             // Split and recurse if we find a bad character
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));

            // Return the longer one
            return left.length() >= right.length() ? left : right;

        }

        return s;

    }
}
