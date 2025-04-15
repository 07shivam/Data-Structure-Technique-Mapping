package Arrays.Two_Pointer;
import java.util.*;

public class Reverse_String {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start<end)
        {
          char temp = s[start];
          s[start] = s[end];
          s[end] = temp;

          start++;
          end--;

        }
    }

    public static void main(String[] args) {
        Reverse_String obj = new Reverse_String();

        char[] input = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Before: " + Arrays.toString(input));

        obj.reverseString(input);

        System.out.println("After: " + Arrays.toString(input));
    }
}