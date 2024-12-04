package DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule
public class L207CourseSchedule {
//https://www.notion.so/DSA-13c8604c11f380559d5cdacadeb95087?pvs=4#14b8604c11f380e98643fcd661a2359d

// Approach: To solve the problem of determining whether all courses can be finished given the prerequisites,
// we can model this problem as a graph. Each course represents a node, and a prerequisite relationship is represented
// as a directed edge between two nodes. The problem then boils down to detecting if there is a cycle in the graph.
// If there is a cycle, it's impossible to finish all courses, otherwise, it is possible.

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] visited = new int[numCourses];

        // Perform DFS on each node
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int course) {

        if (visited[course] == 1) {  // Found a cycle
            return true;
        }

        if (visited[course] == 2) {  // Already processed this course, no cycle found here
            return false;
        }

        visited[course] = 1; // Mark the course as being visited

        for (Integer neighbor : graph.get(course)) {
            if (hasCycle(graph, visited, neighbor)) {
                return true;
            }
        }

        visited[course] = 2; // Mark the course as fully processed
        return false;
    }

    //TC: O(V+E)
    //SC: O(V+E) for storing the graph and the visited array.


    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;  // Each course's inDegree count should reflect the number of prerequisites it has.
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedCourses = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            processedCourses++;

            for (Integer neighbor : graph.get(course)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return numCourses == processedCourses;
    }
}