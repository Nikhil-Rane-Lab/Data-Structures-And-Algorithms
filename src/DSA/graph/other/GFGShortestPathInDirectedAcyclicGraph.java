package DSA.graph.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
public class GFGShortestPathInDirectedAcyclicGraph {
//https://www.youtube.com/watch?v=ZUFQfFaU-8U

    // Approach 1 Using BFS : Topological sorting using Kahn's algorithm
    public int[] shortestPath(int V, int E, int[][] edges) {

        // Step 1: Create adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Topological sorting using Kahn's algorithm
        int[] inDegree = new int[V];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int[] neighborDetails : graph.get(node)) {
                int neighbor = neighborDetails[0];
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Initialize distances
        int[] distArr = new int[V];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[0] = 0; // 💡

        // Step 4: Relax edges based on topological order
        for (int u : topoOrder) {
            if (distArr[u] != Integer.MAX_VALUE) { // By placing this check outside the inner loop, we avoid unnecessary
// processing. If distArr[u] == Integer.MAX_VALUE, it means vertex u is unreachable from the source vertex,
// so we can skip all edges outgoing from u entirely.
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    if (distArr[u] + weight < distArr[v]) {
                        distArr[v] = distArr[u] + weight;
                    }
                }
            }
        }

        // Step 5: Replace unreachable distances with -1
        for (int i = 0; i < V; i++) {
            if (distArr[i] == Integer.MAX_VALUE) {
                distArr[i] = -1;
            }
        }

        return distArr;
    }
// TC & SC: https://www.notion.so/DSA-13c8604c11f380559d5cdacadeb95087?pvs=4#17a8604c11f380959e88d7585e8ac6c0

    //  Approach 2 : Using DFS
    public int[] shortestPath2(int N, int M, int[][] edges) {
        // Step 1: Build the graph adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // Step 2: Perform topological sort
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph, stack);
            }
        }

        // Step 3: Initialize distances and process nodes in topological order
        int[] distArr = new int[N];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[0] = 0; //⭐ here in question it is given that source is always 0 so hardcoded 0 else can give source here

        while (!stack.isEmpty()) {
            Integer u = stack.pop();

            if (distArr[u] != Integer.MAX_VALUE) { // 2 reasons: a) we will later add distArr[u] + weight and we cannot add to Integer.MAX_VALUE
                // b) we can't find weight to reach neighbor node, if we don't even know the weight required to reach the current node
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int weight = edge[1];
                    if (distArr[u] + weight < distArr[v]) {
                        distArr[v] = distArr[u] + weight;
                    }
                }
            }
        }

        // Step 4: Replace unreachable nodes with -1
        for (int i = 0; i < N; i++) {
            if (distArr[i] == Integer.MAX_VALUE) {
                distArr[i] = -1;
            }
        }

        return distArr;
    }

    private void dfs(int node, boolean[] visited, List<List<int[]>> graph, Stack<Integer> stack) {
        visited[node] = true;

        for (int[] edge : graph.get(node)) {
            int neighbor = edge[0];
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph, stack);
            }
        }

        stack.push(node); //In topological sort, node is added at last when all its neighbors are processed.
    }

// TC: O(N+M) as where N is the number of vertices and M is the number of edges.
// This is due to building the adjacency list, topological sort, and edge relaxation.
// SC: O(N) for storing the graph, distance array, and other auxiliary structures.
}
