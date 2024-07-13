package DSA.binarytree;

//https://leetcode.com/problems/count-complete-tree-nodes
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) { //it means its a not just "COMPLETE" but a "PERFECT" Binary Tree.
            return (int) Math.pow(2, leftHeight) - 1; //⭐memorise: this is the formula to get the total number of nodes in a "PERFECT" binary search tree.
        } else {
            // Otherwise, recursively count nodes in left and right subtrees
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}

//A complete binary tree is defined such that every level, except possibly the last, is fully filled, and all nodes are as far left as possible at the last level.
//A perfect binary tree is a type of complete binary tree where all levels are fully filled.
    //TC: O((log n)^2)
    //SC: O(log n)
/*
The time complexity of the algorithm can be analyzed as follows:

- Height Calculation: The `leftHeight` and `rightHeight` functions each traverse the height of the tree,
 which is O(log n) for a complete binary tree where n is the number of nodes.

- Recursive Counting: In the worst case, the algorithm will recursively visit all nodes of the tree.
 Each recursive call does a constant amount of work outside of height calculation (checking if the tree is perfect and subtracting 1 or adding 1). Therefore, the time complexity of the recursive part is O(log n)

- Overall Time Complexity: Combining these, the overall time complexity is O(log n * log n) = O ((log n) ^2).
 This is because at each level of recursion, we perform operations that are logarithmic in complexity, and we recurse logarithmically in the height of the tree.

### Space Complexity (SC):

The space complexity primarily accounts for the space used by the recursive calls and the space used by the function call stack:

- Recursive Stack: In the worst case, the recursion depth can be (O(log n)), corresponding to a balanced tree, where ( n ) is the number of nodes.

- Auxiliary Space: Apart from the stack space, the algorithm uses a constant amount of extra space for variables and method calls,
 making the auxiliary space complexity O(1).

Therefore, the space complexity of the algorithm is O(log n).
*/
