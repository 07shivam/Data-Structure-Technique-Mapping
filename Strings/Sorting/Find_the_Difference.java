package Strings.Sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Find_the_Difference {
        public char findTheDifference(String s, String t) {
        
           char[] str = s.toCharArray();
           Arrays.sort(str);

            char[] str2 = t.toCharArray();
           Arrays.sort(str2);

           int i =0;
           while(i<str.length)
           {
            if(str[i] != str2[i])
            {
                return str2[i];
            }

            i++;
           }

           return str2[i];




    }
}
