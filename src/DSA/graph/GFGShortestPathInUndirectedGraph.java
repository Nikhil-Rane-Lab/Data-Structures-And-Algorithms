package DSA.graph;

import java.util.*;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
public class GFGShortestPathInUndirectedGraph {
//https://www.youtube.com/watch?v=C4gxoTaI71U

    public int[] shortestPath(int[][] edges, int V, int E, int src) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] distArr = new int[V];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[src] = 0; // IMP

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Integer neighbor : graph.get(node)) {
                if (distArr[node] + 1 < distArr[neighbor]) {
                    distArr[neighbor] = distArr[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (distArr[i] == Integer.MAX_VALUE) {
                distArr[i] = -1;
            }
        }
        return distArr;
    }

    //TC: O(V+E) where V is the number of vertices and E is the number of edges.
    // This is because BFS explores each vertex and edge once.
    //SC: O(V+E)
}
