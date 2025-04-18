package Arrays.Two_Pointer;

public class First_Palindromic_String {
    
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (checkPalindrome(words[i])) {
                return words[i];
            }
        }
        return "";
    }
    
    private boolean checkPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
    
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) { // ✅ fix here
                return false;
            }
            left++;
            right--;
        }
    
        return true;
    }
}
