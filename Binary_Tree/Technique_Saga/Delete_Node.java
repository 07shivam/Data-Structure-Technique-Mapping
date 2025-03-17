/*II. Deleting a Node in a Binary Tree (BT)

-Since a Binary Tree does not follow an ordering property, deletion is done as follows:

1. Find the node to be deleted.
2. Replace it with the deepest rightmost node in the tree.
3. Delete the deepest rightmost node.


/*II. Deleting a Node in a Binary Search Tree (BT)

Recap of Recursive Steps
Find the node recursively by traversing the BST.
Delete based on child cases:
No child → return null.
One child → return the non-null child.
Two children → find inorder successor, replace node, and recursively delete successor.
Recursive calls backtrack, updating the tree correctly.
This ensures correct deletion while preserving BST properties. 🚀
Link : */
package Binary_Tree.Technique_Saga;

import java.util.LinkedList;
import java.util.Queue;

import Core.TreeNode;

public class Delete_Node {
    public TreeNode deleteNodeInBinaryTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // If the tree has only one node
        if (root.left == null && root.right == null) {
            return (root.val == key) ? null : root;
        }

        TreeNode keyNode = null;
        TreeNode node = null;
        TreeNode parentNode = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            node = queue.poll();

            // Identify the node to be deleted
            if (node.val == key) {
                keyNode = node;
            }

            // Keep track of the parent of the last node
            if (node.left != null) {
                parentNode = node; // Store parent of last node
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentNode = node;
                queue.offer(node.right);
            }
        }

        // If keyNode is null, return original tree (key not found)
        if (keyNode == null) {
            return root;
        }

        // Swap values of keyNode and last node
        keyNode.val = node.val;

        // Delete the last node properly
        if (parentNode != null) {
            if (parentNode.left == node) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        }

        return root;
    }

    public static TreeNode deleteNodeInBST(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNodeInBST(root.left, key);  // Search in left subtree
        } else if (key > root.val) {
            root.right = deleteNodeInBST(root.right, key); // Search in right subtree
        } else {
            // Node found, now delete it
            if (root.left == null) return root.right; // If only right child exists
            if (root.right == null) return root.left; // If only left child exists
            
            // If two children exist, replace with inorder successor
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNodeInBST(root.right, successor.val);
        }
        return root;
    }

    // Function to find the minimum value node in a BST
    private static TreeNode findMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}
