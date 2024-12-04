package DSA.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view
public class L199BinaryTreeRightSideView {

    //APPROACH: Do BFS and for each level if a node is the last node in the level, add it to result
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) { // if it's the last node in this level, add it to result
                    resultList.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return resultList;
    }

    //TC: O(N) where N is the number of nodes in the tree, since each node is processed once.
    //SC: O(M), where M is the maximum number of nodes at any level in the tree (which is the width of the tree).
    // In the worst case (for a complete binary tree), M could be N/2.
    // The space complexity O(M) is derived from the maximum number of nodes that can be held in the queue at any given time during the breadth-first traversal.
    // In a binary tree, the widest level (the level with the most nodes) determines the peak memory usage for the queue in the BFS approach.
}
