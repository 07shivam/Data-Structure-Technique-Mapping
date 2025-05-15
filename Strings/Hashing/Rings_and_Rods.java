package Strings.Hashing;

import java.util.HashSet;
import java.util.Set;
/*
 Link : https://leetcode.com/problems/rings-and-rods/description/
 */

public class Rings_and_Rods {
    public int countPoints(String rings) {

        // Array of sets to hold colors for each rod
        Set<Character>[] rodColors = new Set[10];
        for (int i = 0; i < 10; i++) {
            rodColors[i] = new HashSet<>();
        }

        // Process each ring (in pairs)
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rodNumber = rings.charAt(i + 1) - '0';

            rodColors[rodNumber].add(color);
        }

        int count = 0;

        for (Set<Character> set : rodColors) {
            if (set.contains('R') && set.contains('G') && set.contains('B')) {
                count++;
            }
        }

        return count;

    }
}
