package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
In the enchanting village of Bookland, there are two mystical bookstores, Alara's Books and Balin's Reads. Your task is to create a program that combines their inventories into a single sorted list.

Input Format:

The first line contains two integers ( n ) and ( m ) (1 ≤ ( n, m ) ≤ 10^5), the sizes of the inventories.
The second line contains ( n ) strings representing the titles of books in Alara's inventory.
The third line contains ( m ) strings representing the titles of books in Balin's inventory.
Output Format:

A single line containing ( n + m ) strings, the combined and sorted list of book titles.
Sample Input 1:

4 4
book enchanted spell wand
ancient dragon magic scroll
Sample Output 1:

ancient book dragon enchanted magic scroll spell wand

 */
public class Combine_the_Books {
    
        public List<String> solve(List<String> inventory1, List<String> inventory2) {
        List<String> combined = new ArrayList<>();
        combined.addAll(inventory1);
        combined.addAll(inventory2);

        // Sort the combined list
        Collections.sort(combined);

        // Return the sorted list
        return combined;


        
    }
}
