/*1859. Sorting the Sentence

A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

 

Example 1:

Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
Example 2:

Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
 */

package Sorting.MindMap;
import java.util.Arrays;

public class SortWordsByNumber {
    public static void main(String[] args) {
        String sentence = "sentence4 a3 is2 This1";
        String sortedSentence = sortSentence(sentence);
        System.out.println("Sorted Sentence: " + sortedSentence);
    }

    public static int compareStringArrayWithStringOnly(String m1, String m2) {
        return (m1).compareTo(m2); 
       
    }

    public static int compareStringArrayWithInteger(String m1, String m2) {
        return Integer.compare(extractNumber(m1), extractNumber(m2));
    }

    public static String sortSentence(String sentence) {

        // Step 1: Split the sentence into words
        String reversed = new StringBuilder(sentence).reverse().toString();
        String[] words = reversed.split(" ");

        // Step 2: Sort words based on the number present in each word
        //Arrays.sort(words);
        Arrays.sort(words, SortWordsByNumber::compareStringArrayWithStringOnly);
        //Arrays.sort(words, SortWordsByNumber::compareStringArrayWithInteger);

        String result = "";
        for(String str : words)
        {
            str = new StringBuilder(str).reverse().toString();
            //remove int from str
            str = appendStringByRemovingInt(str);
            result += str + " ";
            System.out.println("str: " + result);

        }

        return result.trim();
    }

    // Helper function to extract the number from a word
    private static String appendStringByRemovingInt(String word) {
        StringBuilder response = new StringBuilder(); 
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) {
                response.append(c);
            }
        }
        return response.toString();
    }

    private static int extractNumber(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                return c - '0'; // Convert char to integer
            }
        }
        return -1; // This should never happen if input is valid
    }
    
    
}

