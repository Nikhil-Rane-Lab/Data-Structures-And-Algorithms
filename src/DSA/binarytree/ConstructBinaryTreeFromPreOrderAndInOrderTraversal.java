package DSA.binarytree;

import java.util.HashMap;
import java.util.Map;

//Q) https://www.youtube.com/watch?v=aZNaLrVebKQ
public class ConstructBinaryTreeFromPreOrderAndInOrderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderValueToIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderValueToIndexMap.put(inorder[i], i);
        }

        return constructBinaryTree(preorder, 0, 0, preorder.length - 1, inOrderValueToIndexMap);
    }

    private TreeNode constructBinaryTree(int[] preorder, int preOrderStart, int inOrderStart, int inOrderEnd, Map<Integer, Integer> inMap) {

        if (inOrderStart > inOrderEnd) {
            return null;
        }

        int val = preorder[preOrderStart];
        TreeNode root = new TreeNode(val);

        Integer inOrderRootIndex = inMap.get(val);
        int leftSubTreeSize = inOrderRootIndex - inOrderStart;

        root.left = constructBinaryTree(preorder, preOrderStart + 1, inOrderStart, inOrderRootIndex - 1, inMap);
        root.right = constructBinaryTree(preorder, preOrderStart + leftSubTreeSize + 1, inOrderRootIndex + 1, inOrderEnd, inMap);

        return root;
    }

    //TC: O(n)
    //SC: O(n)
}
