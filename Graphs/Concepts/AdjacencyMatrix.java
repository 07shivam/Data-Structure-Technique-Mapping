package Graphs.Concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix {

    public static int[][] createAdjacencyMatrix(int numNodes, int[][] edges) {

        int[][] matrix = new int[numNodes][numNodes];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        return matrix;

    }

    public static List<List<Integer>> createAdjacencyMatrixWithList(int numNodes, int[][] edges) {
        // Initialize the matrix with 0s
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(numNodes, 0));
            matrix.add(row);
        }

        // Fill the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            matrix.get(u).set(v, 1);
            matrix.get(v).set(u, 1); // Remove this for directed graph
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            System.out.print("edge -> " + count++ + " : ");

            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrixForList(List<List<Integer>> matrix) {
        int count = 0;

        for (List<Integer> row : matrix) {
            System.out.print("edge -> " + count++ + " : ");

            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numNodes = 5;
        int[][] edges = {
                { 0, 1 }, { 0, 4 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 3, 4 }
        };

        int[][] matrix = createAdjacencyMatrix(numNodes, edges);
        List<List<Integer>> matrixList = createAdjacencyMatrixWithList(numNodes, edges);
        System.out.println("Adjacency Matrix:");
        printMatrix(matrix);

        System.out.println("Adjacency Matrix with list :");
        printMatrixForList(matrixList);
    }

}
