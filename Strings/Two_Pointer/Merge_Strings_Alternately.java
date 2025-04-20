package Strings.Two_Pointer;

public class Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {


        String result = "";
        boolean toggle = true;
        int i =0, j=0;

        while(i < word1.length() && j< word2.length())
        {
            if(toggle)
            {
                result += word1.charAt(i);
                i++;
            }

            else{
                result += word2.charAt(j);
            }

            toggle = !toggle; 
        }

        while(i<word1.length())
        {
            result += word1.charAt(i);
        }

        while(j<word2.length())
        {
            result += word2.charAt(j);
        }

        return result;

    }
}
