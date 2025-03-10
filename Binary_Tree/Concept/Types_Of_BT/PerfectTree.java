/*
A perfect binary tree is a tree in which:

1. All internal nodes have exactly two children.
2. All leaf nodes are at the same depth (or level).

 Blog Link : Link : https://www.enjoyalgorithms.com/blog/introduction-to-binary-tree 
 */

package Binary_Tree.Concept;

import java.util.LinkedList;
import java.util.Queue;

import Core.TreeNode;

public class PerfectTree {

     public boolean isPerfectTreeItertaive(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0; // Start with 2^0 = 1 node at level 0

        while (!queue.isEmpty()) {
            int levelNodes = queue.size(); // Count nodes at current level

            int expectedNodes = (int) Math.pow(2, level);
            // If nodes at this level do not match expected 2^n nodes, return false
            if (levelNodes != expectedNodes) {
                return false;
            }

            // Process next level
            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            level ++;
        }

        return true;
    }
    
    public boolean isPerfect(TreeNode root) {
        if (root == null) return true; // An empty tree is perfect

        int depth = findDepth(root);
        return isPerfectRecursive(root, 0, depth);
    }

    // Function to find the depth of the leftmost node
    private int findDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    // Recursive function to check if the tree is perfect
    private boolean isPerfectRecursive(TreeNode node, int level, int depth) {
        if (node == null) return true;

        // If it's a leaf node, it must be at the correct depth
        if (node.left == null && node.right == null) {
            return level + 1 == depth;
        }

        // If a node has only one child, it's not perfect
        if (node.left == null || node.right == null) {
            return false;
        }

        // Recursively check both left and right subtrees
        return isPerfectRecursive(node.left, level + 1, depth) &&
               isPerfectRecursive(node.right, level + 1, depth);
    }

    public static void main(String[] args) {
        PerfectTree solution = new PerfectTree();

        // Example 1: Perfect Binary Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        System.out.println("Tree 1 is perfect: " + solution.isPerfect(root1)); // Expected: true
        System.out.println("Tree 1 is perfect Iterative: " + solution.isPerfectTreeItertaive(root1)); // Expected: true


        // Example 2: Not a Perfect Binary Tree (missing one node)
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        System.out.println("Tree 2 is perfect: " + solution.isPerfect(root2)); // Expected: false
        System.out.println("Tree 2 is perfect Iterative: " + solution.isPerfectTreeItertaive(root2)); // Expected: false


        // Example 3: Single Node (Perfect)
        TreeNode root3 = new TreeNode(1);
        System.out.println("Tree 3 is perfect: " + solution.isPerfect(root3)); // Expected: true
        System.out.println("Tree 3 is perfect Iterative: " + solution.isPerfectTreeItertaive(root3)); // Expected: true


        // Example 4: Empty Tree (Perfect)
        TreeNode root4 = null;
        System.out.println("Tree 4 is perfect: " + solution.isPerfect(root4)); // Expected: true
        System.out.println("Tree 4 is perfect Iterative: " + solution.isPerfectTreeItertaive(root4)); // Expected: true

    }
}
