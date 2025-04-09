/*
 Link : https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */

package Searching.MindMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> soldierCount = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int rowSoldierCount = getRowSoldierCount(mat[i]);

            soldierCount.add(new int[] { rowSoldierCount, i }); // {per row soldier count, index}
        }

        Collections.sort(soldierCount, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = soldierCount.get(i)[1]; // Get row index
        }

        return result;
    }

    private int getRowSoldierCount(int[] row) {
        int start = 0;
        int end = row.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (row[mid] == 1) {
                start = mid + 1;
            }

            else {
                end = mid;
            }
        }

        return start;

    }
}
