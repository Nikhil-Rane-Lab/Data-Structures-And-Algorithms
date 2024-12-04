package DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii
public class L210CourseSchedule2 {
// https://www.youtube.com/watch?v=WAOfKpxYHR8
// Kahn's Algorithm : Topological Sort:  https://www.youtube.com/watch?v=73sneFXuTEg

    // Approach: Use Topological Sort using Kahn's Algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 1: Calculate in-degree for each node
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // Step 2: Initialize queue with all nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedCourses = 0;

        int[] result = new int[numCourses];
        int index = 0;

        // Step 3: Process nodes from queue
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            result[index++] = course;
            processedCourses++;

            // Reduce in-degree of adjacent nodes
            for (Integer neighbor : graph.get(course)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Check for cycle
        if (numCourses == processedCourses) {
            return result;
        } else {
            return new int[0];
        }
    }

    //TC: O(V+E)
    //SC: O(V+E)
}

/*
To perform topological sorting of a directed acyclic graph (DAG) using BFS, you can follow these steps:

a) Initialize In-degree:

For each vertex in the graph, calculate the in-degree (the number of incoming edges) and store it in an array.
This array helps track which nodes have no dependencies.
Find All Nodes with Zero In-degree:

b) Add all nodes with zero in-degree (no incoming edges) to a queue. These nodes can be processed immediately since they
don’t depend on any other nodes.
Process Each Node in the Queue:

c) While the queue is not empty, remove a node from the front of the queue.
Add this node to the topological ordering result list.
For each of its adjacent nodes, reduce the in-degree by 1 (since we’re considering that we’ve “used” one of the dependencies).
If an adjacent node’s in-degree becomes zero, add it to the queue (it’s now ready to be processed as all its dependencies
 have been resolved).

d) Check for Cycles:
After processing all nodes, check if the size of the result list equals the number of vertices in the graph.
 If they’re not equal, the graph has a cycle (topological sorting is not possible).
 */
