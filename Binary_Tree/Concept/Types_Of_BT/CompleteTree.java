/*
A Complete Binary Tree (CBT) is a binary tree in which:

- All levels are completely filled, except possibly the last level.
- In the last level, nodes are filled from left to right without any gaps.

 Blog Link : Link : https://www.enjoyalgorithms.com/blog/introduction-to-binary-tree 
 */
package Binary_Tree.Concept;

import java.util.LinkedList;
import java.util.Queue;

import Core.TreeNode;

public class CompleteTree {

    public boolean isCompleteTree1(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                //adding null values into queue too if there is a null value
                queue.offer(node.left);
                queue.offer(node.right);

            } else {
                while (!queue.isEmpty()) {
                    TreeNode checkNullNode = queue.poll();
                    if (checkNullNode != null) {
                        return false;
                    }
                }

            }
        }

        return true;
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true; // An empty tree is complete

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean foundNull = false; // Flag to track first null node

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                foundNull = true; // Once we see a null, all next nodes must also be null
            } else {
                if (foundNull)
                    return false; // If a non-null node appears after a null, it's NOT complete
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // ✅ Complete Binary Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);

        System.out.println("Is Complete Tree? " + isCompleteTree(root1)); // Output: true

        // ❌ Not a Complete Binary Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(5); // Right child exists without left child

        System.out.println("Is Complete Tree? " + isCompleteTree(root2)); // Output: false
    }
}
