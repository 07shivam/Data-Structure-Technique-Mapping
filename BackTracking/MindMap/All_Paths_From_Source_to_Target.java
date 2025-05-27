package BackTracking.MindMap;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target {
     public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(graph, 0, path, result);
        return result;
    }

    private static void backtrack(int[][] graph, int currentNode, List<Integer> path, List<List<Integer>> result) {
        if (currentNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph[currentNode]) {
            path.add(neighbor);
            backtrack(graph, neighbor, path, result);
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        // Example input graph
        int[][] graph = {
            {1, 2},
            {3},
            {3},
            {}
        };

        List<List<Integer>> allPaths = allPathsSourceTarget(graph);

        // Print the output
        System.out.println("All Paths From Source to Target:");
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }
    }
}
