package Searching.MindMap;

public class Search_in_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n-1;

        while(left<right)
        {
            int mid = (left + right)/2;

            int row = mid/m;
            int col = mid%m;

            if (matrix[row][col] == target)
            return true;
            
            else if(matrix[row][col] < target)
            left = mid + 1;

            else
            right = mid - 1;
        }

        return false;
     }
}
