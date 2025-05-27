package Favourite;

import java.util.HashSet;
import java.util.Set;

/*
Link : https://leetcode.com/problems/letter-tile-possibilities/description/

1. Use backtracking to try all possible character combinations.

2. Use a Set to avoid duplicate sequences (since tiles can have duplicate letters like "AA").

3. Use a visited[] array to track which characters have been used in the current path.

 */
public class Letter_Tile_Possibilities {
    
        public int numTilePossibilities(String tiles) {

            Set<String> result = new HashSet<>();
            StringBuilder tempResult = new StringBuilder();
            boolean[] visited = new boolean[tiles.length()];

            numTilePossibilitiesBT(tiles.toCharArray(), tempResult, visited, result);

            return result.size();
        
    }

    public void numTilePossibilitiesBT(char[] tiles, StringBuilder tempResult, boolean[] visited, Set<String> result)
    {
        for(int i=0; i<tiles.length; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                tempResult.append(tiles[i]);
                result.add(tempResult.toString());

                numTilePossibilitiesBT(tiles, tempResult, visited, result);//backtrack

                tempResult.deleteCharAt(tempResult.length()-1);
                visited[i] = false;
                
            }
        }
    }
}
