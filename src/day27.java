import java.util.*;

public class ShortestPathUnweightedGraph {

    // Function to find shortest path using BFS
    public static List<Integer> shortestPath(int V, int[][] edges, int start, int end) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // since undirected
        }

        // Step 2: BFS setup
        boolean[] visited = new boolean[V];
        int[] parent = new int[V]; // to reconstruct path
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        // Step 3: BFS traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end) break; // stop if destination found

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Reconstruct path from end to start
        List<Integer> path = new ArrayList<>();
        if (!visited[end]) {
            return path; // no path found
        }

        for (int at = end; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}
        };
        int start = 0, end = 4;

        List<Integer> path = shortestPath(V, edges, start, end);

        if (path.isEmpty()) {
            System.out.println("No path exists between " + start + " and " + end);
        } else {
            System.out.println("Shortest path from " + start + " to " + end + ": " + path);
        }
    }
}
