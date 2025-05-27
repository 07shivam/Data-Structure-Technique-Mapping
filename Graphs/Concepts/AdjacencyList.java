package Graphs.Concepts;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

     public static List<List<Integer>> createAdjacencyList(int numNodes, int[][] edges) {
        
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize lists
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Remove this line if the graph is directed
        }

        return adjList;
     }

        public static void printAdjList(List<List<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + ": " + adjList.get(i));
        }
    }

    public static void main(String[] args) {
        int numNodes = 5;
        int[][] edges = {
            {0, 1}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 4}
        };

        List<List<Integer>> adjList = createAdjacencyList(numNodes, edges);
        System.out.println("Adjacency List:");
        printAdjList(adjList);
    }
}
