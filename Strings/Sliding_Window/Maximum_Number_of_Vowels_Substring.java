package Strings.Sliding_Window;

import java.util.HashSet;

public class Maximum_Number_of_Vowels_Substring  {

    public int maxVowelsBetterSolution(String s, int k) {
        int maxVowels = 0, currentCount = 0;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int right = 0; right < s.length(); right++) {
            // Add current character if it's a vowel
            if (vowels.contains(s.charAt(right))) {
                currentCount++;
            }

            // Shrink window if it's larger than k
            if (right >= k) {
                if (vowels.contains(s.charAt(right - k))) {
                    currentCount--;
                }
            }

            maxVowels = Math.max(maxVowels, currentCount);
        }

        return maxVowels;
    }


    public int maxVowels(String s, int k) {

        int left = 0, right = 0;
        int maxVowels = 0;
    
        // Initialize a set with vowels
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    
        // Count vowels in the first window
        maxVowels = vowelCount(s, 0, k, vowels);
    
        while (right < s.length()) {
                if (right - left == k) {

                   //check vowel count
                   int count = vowelCount(s, left, right, vowels);
                   maxVowels = Math.max(count, maxVowels);
                    left++;
                }
            else {
                right++;
            }
        }

        return maxVowels;
    }

    private int vowelCount(String s, int left, int right, HashSet<Character> vowels) {
        int count = 0;
        for (int i = left; i < right; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

}
