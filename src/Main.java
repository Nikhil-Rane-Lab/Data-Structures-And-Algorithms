import DSA.binarytree.L117PopulatingNextRightPointersInEachNode2;
import DSA.binarytree.L222CountCompleteTreeNodes;
import DSA.binarytree.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        int countNodes = new L222CountCompleteTreeNodes().countNodes(root);
    }
}
