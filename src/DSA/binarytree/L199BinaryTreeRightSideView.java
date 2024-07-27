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

    //TC: O(N)
    //SC: O(D) where D is the maximum depth of the binary tree.
    // In the worst case, the space required for the queue is proportional to the number of nodes at the deepest level.
}
