package Strings.Simple;


public class Split_String_Balanced_Strings
{
 public int balancedStringSplit(String s) {
        int isBalanced = 0;
        int totalCount= 0;
        for(char c : s.toCharArray())
        {
            if(c == 'L')
            {
                isBalanced++;
            }

            if(c == 'R')
            {
                isBalanced--;
            }

             if(isBalanced == 0)
            {
               totalCount++;
            }


        }

        return totalCount;
    }
}