package DSA.graph.other;

// https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
public class GFGFloodFillAlgorithm {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];

        // If the original color is the same as the new color, no filling is needed
        if (initialColor == newColor) {
            return image;
        }

        dfs(image, sr, sc, newColor, initialColor); // Perform flood fill starting from (sr, sc)
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int initialColor) {
        // Base case: if out of bounds or not the initial color
        if (sr < 0 || sr >= image.length
                || sc < 0 || sc >= image[0].length
                || image[sr][sc] != initialColor) { // ⚠️
            return;
        }

        image[sr][sc] = newColor; // Change the color of the current pixel

        dfs(image, sr - 1, sc, newColor, initialColor); //up
        dfs(image, sr + 1, sc, newColor, initialColor); //down
        dfs(image, sr, sc - 1, newColor, initialColor); //left
        dfs(image, sr, sc + 1, newColor, initialColor); //right
    }
}
// TC: O(N * M) where N is the number of rows and M is the number of columns.
// In the worst case, all pixels need to be visited.
// SC: O(N * M) which is due to the recursion stack for the DFS call (or a queue if using BFS). In the worst case,
// if the image is entirely filled with the starting color, the recursion stack could reach N * M depth.