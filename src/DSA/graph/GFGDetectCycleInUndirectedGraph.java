package DSA.graph;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class GFGDetectCycleInUndirectedGraph {
//https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12&pp=iAQB

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleExistsByDFS(i, -1, visited, adj)) { // ⚠️ parent is passed as any value say -1
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCycleExistsByDFS(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;

        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (isCycleExistsByDFS(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) { // If the neighbor is visited and not the parent, we found a cycle
                return true;
            }
            // ⚠️ there is return true in both if block and else block
        }

        return false;
    }

    //TC: O(V+E) - Each vertex and edge is processed once in DFS, where V is the number of vertices and  E is the number of edges.
    //SC: O(V) - We need extra space for the visited array and the recursive call stack in DFS.
}