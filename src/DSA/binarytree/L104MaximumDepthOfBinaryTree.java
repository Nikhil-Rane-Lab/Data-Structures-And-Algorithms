package DSA.binarytree;

//Q) https://leetcode.com/problems/maximum-depth-of-binary-tree
public class L104MaximumDepthOfBinaryTree {
//🤩 https://www.youtube.com/watch?v=eD3tmO66aBA

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return 1 + Math.max(maxLeft, maxRight);
     }

     //TC: O(n) where n is the number of the nodes in the tree
     //SC: O(h) where h is the height of the tree
}
