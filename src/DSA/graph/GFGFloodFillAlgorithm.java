package DSA.graph;

public class GFGFloodFillAlgorithm {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        if (initialColor == newColor) {
            return image;
        }

        dfs(image, sr, sc, newColor, initialColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int initialColor) {
        if (sr < 0 || sr >= image.length
                || sc < 0 || sc >= image[0].length
                || image[sr][sc] != initialColor) {
            return;
        }

        image[sr][sc] = newColor;

        dfs(image, sr - 1, sc, newColor, initialColor); //up
        dfs(image, sr + 1, sc, newColor, initialColor); //down
        dfs(image, sr, sc - 1, newColor, initialColor); //left
        dfs(image, sr, sc + 1, newColor, initialColor); //right
    }
}
    //TC: O(n*m) where n is the number of rows and m is the number of columns.
    // In the worst case, all pixels need to be visited.
    //SC: O(n*m)