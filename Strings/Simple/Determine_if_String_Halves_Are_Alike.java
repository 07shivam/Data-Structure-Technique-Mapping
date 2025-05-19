package Strings.Simple;

import java.util.HashSet;
import java.util.Set;
/*
 Link : https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */
public class Determine_if_String_Halves_Are_Alike {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int vowelsCount = 0;

        int mid = (s.length() / 2);
        for (int i = 0; i < mid; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(mid + i);

            if (vowels.contains(ch1))
                vowelsCount++;
            if (vowels.contains(ch2))
                vowelsCount--;
        }

        return vowelsCount == 0;

    }
}
