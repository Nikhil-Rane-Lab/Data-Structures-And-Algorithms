package DSA.stack;

import java.util.Stack;

//https://leetcode.com/problems/simplify-path
public class L71SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue; // Skip empty components or "." (current directory)
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go up one directory level if possible
                }
            } else {
                stack.push(component); // Add valid directory names to the stack
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir); //⚠️ here we are simply printing the element in the stack in the order in which they were added
        }

        return !sb.isEmpty() ? sb.toString() : "/";
    }
}

//TC: O(N) as we process each character in the input path once when splitting and then again when processing each component.
//SC: O(N) as in the worst case, all components might be stored in the stack.
