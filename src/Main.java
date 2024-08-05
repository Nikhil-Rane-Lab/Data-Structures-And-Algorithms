import DSA.binarytree.L117PopulatingNextRightPointersInEachNode2;

public class Main {
    public static void main(String[] args) {
        // Create the tree [1, 2, 3, 4, 5, null, 7]
        L117PopulatingNextRightPointersInEachNode2.Node root = new L117PopulatingNextRightPointersInEachNode2.Node(1);
        root.left = new L117PopulatingNextRightPointersInEachNode2.Node(2);
        root.right = new L117PopulatingNextRightPointersInEachNode2.Node(3);
        root.left.left = new L117PopulatingNextRightPointersInEachNode2.Node(4);
        root.left.right = new L117PopulatingNextRightPointersInEachNode2.Node(5);
        root.right.right = new L117PopulatingNextRightPointersInEachNode2.Node(7);

        // Call the connect method
        L117PopulatingNextRightPointersInEachNode2 solution = new L117PopulatingNextRightPointersInEachNode2();
        L117PopulatingNextRightPointersInEachNode2.Node connectedRoot = solution.connect(root);

        // Print the level order traversal using 'next' pointers
        printLevels(connectedRoot);
    }

    // Helper function to print the tree level by level using 'next' pointers
    public static void printLevels(L117PopulatingNextRightPointersInEachNode2.Node root) {
        L117PopulatingNextRightPointersInEachNode2.Node levelStart = root;
        while (levelStart != null) {
            L117PopulatingNextRightPointersInEachNode2.Node current = levelStart;
            levelStart = null;
            L117PopulatingNextRightPointersInEachNode2.Node prev = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (levelStart == null) {
                    levelStart = current.left != null ? current.left : current.right;
                }
                if (prev != null) {
                    prev.next = current.next;
                }
                prev = current;
                current = current.next;
            }
            System.out.println("#"); // Indicate the end of the current level
        }
    }
}
