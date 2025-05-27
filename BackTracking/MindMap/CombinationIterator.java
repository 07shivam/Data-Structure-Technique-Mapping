package BackTracking.MindMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    List<String> combination;
    private int index;

    public CombinationIterator(String characters, int combinationLength) {
        combination = new ArrayList<>();
        generateCombinationIterator(characters, combination, 0, combinationLength, new StringBuilder());
        index = 0;

    }

    public void generateCombinationIterator(String characters, List<String> combination, int start,
            int combinationLength, StringBuilder str) {
        if (str.length() == combinationLength) {
            combination.add(str.toString());
        }

        for (int i = start; i < characters.length(); i++) {
            str.append(characters.charAt(i));
            generateCombinationIterator(characters, combination, i+1, combinationLength, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public String next() {
        return combination.get(index++);
    }

    public boolean hasNext() {
        return index < combination.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */