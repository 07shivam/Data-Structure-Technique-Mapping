package Maps;

import java.util.HashMap;
import java.util.Map;

public class Frequency {
    
    public int firstUniqChar(String s) {

       //return firstUniqCharUsingArray(s);

       return firstUniqCharUsingMap(s);
        
    }

    private int firstUniqCharUsingMap(String s) {
        
        Map<Character, Integer> frequecyMap = new HashMap<>();

        //cal frequecy using map respectively for each char
        for(char ch : s.toCharArray())
        {
            frequecyMap.put(ch, frequecyMap.getOrDefault(ch, 0) + 1 );
        }

        
        
        return -1;
    }

    public int firstUniqCharUsingArray(String s)
    {
        //create a frequecy array respectively for each char
        int [] frequecy = new int[26];

        for(char ch : s.toCharArray())
        {
            frequecy[ch - 'a']++;
        }

        //find the first non repeasting char in String s
        for(int i =0; i< s.length(); i++)
        {
            if(frequecy[s.charAt(i) - 'a'] == 1)
            return i;
        }

        return -1;

    }
}
