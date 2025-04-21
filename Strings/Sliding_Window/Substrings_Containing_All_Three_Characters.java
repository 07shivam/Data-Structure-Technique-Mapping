/*
Link : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

1.Maintain a frequency map for a,b and c characters
2.Maintain a sliding window till right reaches end
2.1 Explain the right side until you get the count of a,b and c atleast 1 time for each character
2.1.2 once we get our one substring (a,b,c), now every substring post right is also eligible for "Substrings_Containing_All_Three_Characters"

therefore count += length(s) - right; all substrings from this left to end are valid

s = "abcabc"

left = 0, right = 2
window = "abc" → contains all 3

→ s.length() - right = 6 - 2 = 4

res += 4 → substrings = "abc", "abca", "abcab", "abcabc"

now shrink left side and repeat

2.3 Now, shrink from the left as much as possible while still checking if frequency map for a,b and c has atleast one time for each character

Note : 

*/
package Strings.Sliding_Window;

public class Substrings_Containing_All_Three_Characters {
    public int numberOfSubstrings(String s) {

        int [] freq = new int[3];
        int left =0;
        int count = 0;

        for(int right =0; right< s.length(); right++)
        {
            freq[s.charAt(right)- 'a']++;

            /*'a' - 'a' = 0
            'b' - 'a' = 1
            'c' - 'a' = 2
            This converts characters 'a', 'b', and 'c' into indices 0, 1, and 2.
            */

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0)
            {
                count += s.length() - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }

        }

        return count;
        
    }
}
