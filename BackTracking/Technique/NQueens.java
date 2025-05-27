package BackTracking.Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        char[][] chessBoard = new char[n][n];

        // intitalise the board
        for (int i = 0; i < n; i++)
            Arrays.fill(chessBoard[i], '.'); // Set all columns in row i to '.' (empty square)

        List<List<String>> result = new ArrayList<>();

        solveNQueensWithBackTracking(chessBoard, result, 0, n);

        return result;

    }

    private void solveNQueensWithBackTracking(char[][] chessBoard, List<List<String>> result, int row, int n) {

        // Base Case
        if (n == row) {
            // construct list of string and add it to the result board
            result.add(constructResult(chessBoard));
            return;
        }

        //
        for (int col = 0; col < n; col++) {
            if (isSafe(chessBoard, row, col, n)) {
                chessBoard[row][col] = 'Q';
                solveNQueensWithBackTracking(chessBoard, result, row + 1, n);
                chessBoard[row][col] = '.'; // BackTrack
            }
        }
    }

    private boolean isSafe(char[][] chessBoard, int row, int col, int n) {
        // check row
        for (int i = 0; i < n; i++) {
            if (chessBoard[row][i] == 'Q') {
                return false;
            }
        }

        // check column
        for (int i = 0; i < n; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        // check left diagonal
        for(int i=row-1, j= col-1; i>=0 && j>=0; i--, j--)
        {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // check righ diagonal

        for(int i=row-1, j= col+1; i>=0 && j < n; i--, j++)
        {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        } 

        return true;
    }

    private List<String> constructResult(char[][] chessBoard) {
        // TODO Auto-generated method stub
        List<String> s=new ArrayList<>();
        for(int i=0;i <chessBoard[0].length; i++)
        {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j< chessBoard[0].length; j++)
            {
                row.append(chessBoard[i][j]);
            }

        s.add(row.toString());
        }

        return s;
    }

}
