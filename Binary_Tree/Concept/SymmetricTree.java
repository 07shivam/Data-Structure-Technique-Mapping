package Binary_Tree.Concept;

import Core.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    // 🔹 Recursive Approach (DFS)
    public static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) 
                && isMirror(t1.left, t2.right) 
                && isMirror(t1.right, t2.left);
    }

    // 🔹 Iterative Approach (BFS using Queue)
    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            // Enqueue opposite children to check symmetry
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1: Symmetric Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println("Is Symmetric (Recursive)? " + isSymmetricRecursive(root1)); // Output: true
        System.out.println("Is Symmetric (Iterative)? " + isSymmetricIterative(root1)); // Output: true

        // Example 2: Non-Symmetric Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println("Is Symmetric (Recursive)? " + isSymmetricRecursive(root2)); // Output: false
        System.out.println("Is Symmetric (Iterative)? " + isSymmetricIterative(root2)); // Output: false
    }
}
