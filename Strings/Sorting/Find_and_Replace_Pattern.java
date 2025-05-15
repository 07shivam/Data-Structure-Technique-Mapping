package Strings.Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_and_Replace_Pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();
        String encodedPattern = Encode(pattern);

        for (String word : words) {
            if(Encode(word) == encodedPattern)
            {
                result.add(word);
            }
        }

        return result;
    }

    public String Encode(String str)
    {
        int code=0;
        Map<Character, Integer> mapEncode = new HashMap<>();
        StringBuilder sb = new StringBuilder();


        for(char ch : str.toCharArray())
        {
            if(!mapEncode.containsKey(ch))
            {
                mapEncode.put(ch, code++);
            }

            sb.append(mapEncode.get(ch));
        }

       return sb.toString();
    }
}
