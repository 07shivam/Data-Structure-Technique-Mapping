/*
 s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1]
 */
package Arrays.Two_Pointer;

public class DI_String_Match {
    public int[] diStringMatch(String s) {
        int[]result = new int[s.length() + 1 ];

        int left = 0;
        int right = s.length();
        int counter = 0;

  
        for(int i =0; i<s.length(); i++)
        {
            if(s.charAt(i) == 'I')
            {
                result[i] = left;
                counter++;
                left++;
            }

            else{
                result[i] = right;
                counter++;
                right--;
            }
        }

        if(s.charAt(s.length() -1 ) == 'I')
        {
            result[counter] = left;
        }

        else
        {
            result[counter] = right;
        }

        return result;

    }
}
