package DSA.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GFGBipartiteGraph {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i, adj, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer neighbor : adj.get(current)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = color[current] == 0 ? 1 : 0;
                    queue.add(neighbor);
                } else if (color[neighbor] == color[current]) {
                    return false;
                }
            }
        }

        return true;
    }

    //TC: O(V+E)  where V is the number of vertices and E is the number of edges.
    // This is because we visit each vertex and edge once.
    //SC: O(V) for the color array and the queue used in BFS.
}
