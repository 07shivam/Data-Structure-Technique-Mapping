/* Example 1: Balanced Binary Tree
PreOrder : https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/1574840855/

markdown
Copy
Edit
        1
       / \
      2   3
     / \   \
    4   5   6
Expected Output
Preorder (Root → Left → Right): 1 2 4 5 3 6
Inorder (Left → Root → Right): 4 2 5 1 3 6

Example 2: Full Binary Tree
markdown
Copy
Edit
        10
       /  \
      20   30
     /  \
    40   50
Expected Output
Preorder: 10 20 40 50 30
Inorder: 40 20 50 10 30
Postorder: 40 50 20 30 10


Random Binary Tree
markdown
Copy
Edit
         15
       /    \
      10     25
     / \     / 
    5   12  20
        /
       11
Expected Output
Preorder: 15 10 5 12 11 25 20
Inorder: 5 10 11 12 15 20 25
Postorder: 5 11 12 10 20 25 15

 */
package Binary_Tree.Concept.Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Core.TreeNode;

public class BinaryTreeTraversals {

    public static void reverseLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            stack.push(node); // Store nodes in stack for reverse order

            // Push right child first, then left (so left comes first when popped)
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
        }

        // Print nodes from stack (bottom-to-top order)
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
    }

    public static void reverseLevelOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.right != null)
                queue.offer(node.right);
                if (node.left != null)
                    queue.offer(node.left);

            }
        }
    }

    public static void levelOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
    }

    // 🔹 Recursive Preorder Traversal (Root → Left → Right)
    public static void preorderRecursive(TreeNode root) {

        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    // 🔹 Iterative Preorder Traversal
    public static void preorderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    // 🔹 Recursive Inorder Traversal (Left → Root → Right)
    public static void inorderRecursive(TreeNode root) {
        if (root == null)
            return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    // 🔹 Iterative Inorder Traversal
    public static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    // 🔹 Recursive Postorder Traversal (Left → Right → Root)
    public static void postorderRecursive(TreeNode root) {
        if (root == null)
            return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    // 🔹 Iterative Postorder Traversal
    public static void postorderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    // 🔹 Driver Code
    public static void main(String[] args) {
        /*
         * Tree Structure:
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Preorder (Recursive): ");
        preorderRecursive(root);
        System.out.println("\nPreorder (Iterative): ");
        preorderIterative(root);

        System.out.println("\n\nInorder (Recursive): ");
        inorderRecursive(root);
        System.out.println("\nInorder (Iterative): ");
        inorderIterative(root);

        System.out.println("\n\nPostorder (Recursive): ");
        postorderRecursive(root);
        System.out.println("\nPostorder (Iterative): ");
        postorderIterative(root);

        System.out.println("\nLevel (Recursive): ");
        levelOrderTraversal(root);

        System.out.println("\n reverseLevelOrder (Recursive): ");
        reverseLevelOrder(root);
        System.out.println("\n reverseLevelOrder (Recursive): ");

        reverseLevelOrderTraversal(root);
        
    }
}
