package Binary_Tree.Concept;

import java.util.LinkedList;
import java.util.Queue;

import Core.TreeNode;

public class SkewedTree {

     public boolean isSkewedTreeIterative(TreeNode root) {
        if (root == null) return true; // Empty tree is skewed

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            // A node should have at most one child
            if (node.left != null && node.right != null) {
                return false; // Found a node with two children, not skewed
            }

            // Enqueue the existing child (either left or right)
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return true; // All nodes had at most one child, it's a skewed tree
    }

    public boolean isSkewedTree(TreeNode root) {
        if (root == null) return true; // An empty tree is skewed

        if (root.left != null && root.right != null) return false; // A node with two children is NOT skewed
        
        /*
        Call isSkewedTree(root.left) if there's a left child
        Call isSkewedTree(root.right) if there's a right child
        Since it's either left or right, we use || (logical OR)
        */
        return isSkewedTree(root.left) || isSkewedTree(root.right);
    }

    public static void main(String[] args) {
        SkewedTree sol = new SkewedTree();

        // Left-Skewed Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        System.out.println(sol.isSkewedTree(root1)); // true

        // Right-Skewed Tree
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);
        System.out.println(sol.isSkewedTree(root2)); // true

        // Not a Skewed Tree
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3); // Two children!
        System.out.println(sol.isSkewedTree(root3)); // false
    }
}
