package BackTracking.MindMap;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

   public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        StringBuilder tempStr = new StringBuilder();
        boolean visited[] = new boolean[s.length()];

        letterCasePermutationBT(s.toCharArray(), result, tempStr, 0, visited);
        return result;

    }

    private void letterCasePermutationBT(char[] str, List<String> result, StringBuilder tempStr, int index,
            boolean[] visited) {
        // TODO Auto-generated method stub
        if (str.length == tempStr.length()) {
            result.add(tempStr.toString());
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;

            if (Character.isLetter(str[i])) {
                // lowercase
                tempStr.append(Character.toLowerCase(str[i]));
                // backtract
                letterCasePermutationBT(str, result, tempStr, i + 1, visited);
                tempStr.deleteCharAt(tempStr.length() - 1);

                // uppercase
                tempStr.append(Character.toUpperCase(str[i]));
                // backtract
                letterCasePermutationBT(str, result, tempStr, i + 1, visited);
                tempStr.deleteCharAt(tempStr.length() - 1);
            }

            else {
                // Digit - only one possibility

                tempStr.append(str[i]);
                letterCasePermutationBT(str, result, tempStr, i + 1, visited);
                tempStr.deleteCharAt(tempStr.length() - 1);
            }

            visited[i] = false;
            break;

        }
    }
}
