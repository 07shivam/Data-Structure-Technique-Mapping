/*
 A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 */

package Binary_Tree.Concept;
import java.util.*;
import Core.TreeNode; // Correctly importing TreeNode

public class FullTree {

    public static boolean isFullTree(TreeNode root) {
        if (root == null) return true; // An empty tree is considered full

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Case: If node has only one child, it's NOT a full tree
            if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                return false;
            }

            // Continue checking left and right children
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return true; // If we never found a node with a single child, it's full
    }

    public static boolean isFullTreeRecussive(TreeNode root) {
      // Base Case: If tree is empty, it's full
      if (root == null) return true;

      // If it's a leaf node, it's full
      if (root.left == null && root.right == null) return true;

      // If a node has exactly one child, it's NOT full
      if (root.left == null || root.right == null) return false;

      // Recursively check both left and right subtrees
      return isFullTree(root.left) && isFullTree(root.right);

    }

    public static void main(String[] args) {
        // Creating a Full Binary Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        System.out.println("Is Full Tree? " + isFullTree(root1)); // Output: true
        System.out.println("Is Full Tree Recurssive? " + isFullTreeRecussive(root1)); // Output: false


        // Creating a Non-Full Binary Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4); // Left child, but no right child

        System.out.println("Is Full Tree? " + isFullTree(root2)); // Output: false
        System.out.println("Is Full Tree Recurssive? " + isFullTreeRecussive(root2)); // Output: false



    }
}
