package DSA.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Q) https://leetcode.com/problems/binary-tree-level-order-traversal/
public class L102BinaryLevelOrderTraversal {
//https://www.youtube.com/watch?v=EoAsWbO7sqg&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=8

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();

            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < currLevelSize; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
                subList.add(currNode.val);
            }

            result.add(subList);
        }

        return result;
    }

    //TC: O(n) Each node is processed exactly once, and enqueuing and dequeuing operations take O(1) time.
    //SC: O(n) The main space usage is the queue, which at most holds the nodes of one level. In the worst case, the largest level can be up to n/2 nodes.
}
