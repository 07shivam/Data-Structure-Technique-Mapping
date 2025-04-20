package Strings.Two_Pointer;

public class Reverse_Prefix_Word {

    public String reversePrefix(String word, char ch) {
        
        int left = 0;
        char[] charStr = word.toCharArray();// Java String is immutable, meaning its contents cannot be changed directly
        for (int right = 0; right <= charStr.length; right++) {
            if (charStr[right] == ch) { 
                reverse(charStr, left, right - 1);
            }
        }
    
        return new String(charStr);

    }

    private void reverse(char[] charStr, int left, int right) {
        while (left < right) {
            char temp = charStr[left];
            charStr[left] = charStr[right];
            charStr[right] = temp;
            left++;
            right--;
        }

    }
    

}
