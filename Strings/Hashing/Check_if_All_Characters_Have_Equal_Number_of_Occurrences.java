package Strings.Hashing;

import java.util.HashMap;
import java.util.Map;
/*
Link : https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/

Approach Using a HashMap
Count frequency of each character using Map<Character, Integer>.

Store the frequency of the first character as a reference.

Compare all other character frequencies to that reference.

If any mismatch is found, return false.

 */
public class Check_if_All_Characters_Have_Equal_Number_of_Occurrences {
        public boolean areOccurrencesEqual(String s) {
        
            Map<Character, Integer> freqMap = new HashMap<>();

            for(char ch : s.toCharArray())
            {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            int target = -1;
            for(int freqValue : freqMap.values())
            {
                if(target == -1)
                {
                    target = freqValue;
                }

                if(target != freqValue)
                return false;
            }

            return true;
    }
}
