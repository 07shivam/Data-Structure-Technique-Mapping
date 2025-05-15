package Arrays.Hashing;

import java.util.HashSet;
import java.util.Set;

public class Unique_Morse_Code_Words {
        public int uniqueMorseRepresentations(String[] words) {
        
            String[] morseCode = new String[]
            {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
            };

            Set<String> uniqueMorseCode = new HashSet<>();

            for(String word : words)
            {
                String str ="";
                for(char ch : word.toCharArray())
                {
                    str += morseCode[ ch - 'a'];
                }

                uniqueMorseCode.add(str);
            }

            return uniqueMorseCode.size();
            
    }
}
