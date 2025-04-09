/*
 * Link  : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
package Searching.MindMap;

public class Count_Negatives_In_2D {
    public int countNegatives(int[][] grid) {
        int totalCount = 0;
        int row = grid.length - 1;
        int col = 0;
        int colLength = grid[0].length;
        
        System.out.println("row Length" + row);

        System.out.println("column Length" + colLength);

        while (row >= 0 && col < colLength) {
            if (grid[row][col] < 0) {
                System.out.println("Total : " + totalCount + " colLength : " + colLength + " - column : " + col);
                totalCount += colLength - col;
                row--;
            }

            else {
                col++;
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        Count_Negatives_In_2D solution = new Count_Negatives_In_2D();

        int[][] grid1 = {
            {4, 3, 2, 1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };

        int[][] grid2 = {
            {3, 2},
            {1, 0}
        };

        System.out.println("Grid 1 Negative Count: " + solution.countNegatives(grid1)); // Output: 8
        System.out.println("Grid 2 Negative Count: " + solution.countNegatives(grid2)); // Output: 0
    }
}
