package DSA.binarytree;

import java.util.*;

//https://leetcode.com/problems/average-of-levels-in-binary-tree
public class L637AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(sum / size);
        }

        return result;
    }

//    TC: O(N)
//    SC: O(M), where M is the maximum number of nodes at any level of the tree. For a balanced tree (worst case), M≈N/2.
}
