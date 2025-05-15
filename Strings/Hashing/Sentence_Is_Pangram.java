package Strings.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 Link : https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
 */

public class Sentence_Is_Pangram {
    public boolean checkIfPangram(String sentence) {

        Set<Character> alphabetSet = new HashSet<>();

        for (char ch : sentence.toCharArray()) {
            // if (ch >= 'a' && ch <= 'z') {
            //     alphabetSet.add(ch);
            // }
             alphabetSet.add(Character.toLowerCase(ch));
        }

        if(alphabetSet.size() == 26)
        {
        return true;

        }

        return false;


    }
}
