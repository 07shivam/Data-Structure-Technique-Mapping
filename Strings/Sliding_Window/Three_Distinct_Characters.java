package Strings.Sliding_Window;

import java.util.HashSet;

public class Three_Distinct_Characters {
    public int countGoodSubstrings(String s) {
        int left = 0, right = 0;
        int count = 0;
        int k = 3;
        HashSet<Character> c = new HashSet<>();

        while (right < s.length()) {

            if (c.add(s.charAt(right))) {
                right++;

                if (right - left == k) {
                    count++;
                    c.remove(s.charAt(left));
                    left++;
                }
            } else {
                c.remove(s.charAt(left));
                left++;
            }
        }

        return count;
    }

    public int countGoodSubstringsWithSet(String s) {       
               int count = 0;
               int n = s.length();
       
               for (int i = 0; i <= n - 3; i++) {
                   HashSet<Character> set = new HashSet<>();
                   set.add(s.charAt(i));
                   set.add(s.charAt(i + 1));
                   set.add(s.charAt(i + 2));
       
                   if (set.size() == 3) {
                       count++;
                   }
               }
       
               return count;
       
           }
}
