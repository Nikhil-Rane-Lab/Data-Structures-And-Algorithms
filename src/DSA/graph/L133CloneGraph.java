package DSA.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/clone-graph/description
public class L133CloneGraph {

    Map<Node, Node> originalToCopyNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (originalToCopyNodeMap.containsKey(node)) {
            return originalToCopyNodeMap.get(node);
        }

        Node copyNode = new Node(node.val, new ArrayList<>());
        originalToCopyNodeMap.put(node, copyNode); //⭐ this line cannot be added after the for-loop

        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        return copyNode;
    }

//    TC: O(V + E), where V is the number of vertices (nodes) and E is the number of edges.
//    SC: O(V), as we use a hash map to store the cloned nodes.

    //Already given in question
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
