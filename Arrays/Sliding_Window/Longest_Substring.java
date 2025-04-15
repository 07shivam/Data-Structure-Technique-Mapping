package Arrays.Sliding_Window;

import java.util.HashSet;

public class Longest_Substring {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> longestSubStringSoFar = new HashSet<>();

        int i=0, j=0;
        int longestSubStringLength = 0;
        int n = s.length();

        while(j<n)
        {
            if(!longestSubStringSoFar.contains(s.charAt(j)))
            {
                longestSubStringSoFar.add(s.charAt(j));
                longestSubStringLength = Math.max(j-i+1, longestSubStringLength); 
                j++;
            }
            else{
                longestSubStringSoFar.remove(s.charAt(i));
                i++;
            }
        }

        return longestSubStringLength;
    
    }
    public int lengthOfLongestSubstringasd(String s) {
        HashSet<Character>hash=new HashSet<>();
        int max=0;
        int i=0,j=0;
        while(j<s.length())
        {
            if(!hash.contains(s.charAt(j)))
            {
                hash.add(s.charAt(j));
                max=Math.max(max,j-i+1);
                j++;
            }
            else
            {
                hash.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
