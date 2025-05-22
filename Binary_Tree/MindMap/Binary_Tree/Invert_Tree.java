package Binary_Tree.MindMap.Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

import Utility.TreeNode;

public class Invert_Tree {
    public TreeNode invertTree(TreeNode root) {
        return invertTreeBFS(root);
    }

    private TreeNode invertTreeBFS(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null)
            return null; // Base case

        TreeNode temp = root.left;
        root.left = invertTreeDFS(root.right);
        root.right = invertTreeDFS(temp);

        return root;
    }

    public static void main(String[] args) {
        Invert_Tree tree = new Invert_Tree();

        // Creating sample tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original Tree (Pre-order): ");
        printInOrder(root);

        // Inverting tree
        TreeNode invertedRoot = tree.invertTree(root);

        System.out.println("\nInverted Tree BFS: ");
        printInOrder(invertedRoot);

        // Inverting tree
        TreeNode invertedRoot2 = tree.invertTreeDFS(root);

        System.out.println("\nInverted Tree DFS: ");
        printInOrder(invertedRoot2);
    }

    // Helper method to print tree in Pre-order
    public static void printInOrder(TreeNode node) {
        if (node == null)
            return;
            System.out.print(node.val + " ");

            printInOrder(node.left);

        printInOrder(node.right);
    }
}
