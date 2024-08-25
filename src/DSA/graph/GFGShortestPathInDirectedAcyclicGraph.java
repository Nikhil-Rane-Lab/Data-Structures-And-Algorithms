package DSA.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph
public class GFGShortestPathInDirectedAcyclicGraph {
//https://www.youtube.com/watch?v=ZUFQfFaU-8U

    public int[] shortestPath(int N, int M, int[][] edges) {
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

            if (distArr[u] != Integer.MAX_VALUE) { // 2 things: a) we will later add distArr[u] + weight and we cannot add to Integer.MAX_VALUE
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

    //TC: O(N+M) as O(N+M) is required "each" for topological sorting, relaxation and
    //SC: O(N) for storing the graph, distance array, and other auxiliary structures.
}
