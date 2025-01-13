package DSA.graph.other;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/number-of-provinces/1
public class GFGNumberOfProvinces {
//here input is adjacency matrix given as adjacency list 🥲

    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(node).get(i) == 1 //⭐ this check if "i" is a neighbor of node
                    && !visited[i]) { //⭐ if yes, then this checks if the neighbor is unvisited
                dfs(i, adj, visited);
            }
        }
    }

    //TC: O(V*V)
    //SC: O(V)
}
