package Strings.Two_Pointer;

public class Reverse_Words_III {
    public String reverseWords(String s) {
        int left = 0;
        char[] charStr = s.toCharArray();// Java String is immutable, meaning its contents cannot be changed directly
        for (int right = 0; right <= charStr.length; right++) {
            if (right == charStr.length || charStr[right] == ' ') { //1st condition for getting last word of sentense
                reverse(charStr, left, right - 1);
                left = right + 1;
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

