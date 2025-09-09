import java.util.*;

public class DetectCycleUndirectedGraph {

    // Function to check if graph contains cycle
    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Check each component of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true; // cycle found
                }
            }
        }
        return false;
    }

    // DFS function to detect cycle
    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Found a cycle
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0} };

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // since undirected
        }

        if (hasCycle(V, adj)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }
}
