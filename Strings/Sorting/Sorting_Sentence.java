package Strings.Sorting;

import java.util.Arrays;

public class Sorting_Sentence {

    public String sortSentence(String sentence) {

        // Step 1: Split the sentence into words
        String reversed = new StringBuilder(sentence).reverse().toString();
        String[] words = reversed.split(" ");

        // Step 2: Sort words based on the number present in each word
        // Arrays.sort(words);
        Arrays.sort(words, Sorting_Sentence::compareStringArray);
        String result = "";
        for (String str : words) {
            str = new StringBuilder(str).reverse().toString();
            // remove int from str
            str = extractNumber(str);
            result += str + " ";
        }

        return result.trim();
    }

    public static int compareStringArray(String m1, String m2) {
        return (m1).compareTo(m2);

    }

    // Helper function to extract the number from a word
    private static String extractNumber(String word) {
        StringBuilder response = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) {
                response.append(c);
            }
        }
        return response.toString();
    }

    public static void main(String[] args) {
        Sorting_Sentence sorter = new Sorting_Sentence();

        String input = "is2 sentence4 This1 a3";
        String output = sorter.sortSentence(input);

        System.out.println("Original: " + input);
        System.out.println("Sorted:   " + output);
    }

}