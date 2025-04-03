/*
 * Link : https://leetcode.com/problems/univalued-binary-tree/
 */

package Binary_Tree.MindMap.Binary_Tree;
import Core.TreeNode;
import java.util.*;

public class Is_Unival_Tree {
    // DFS Approach
    public boolean isUnivalTreeDFS(TreeNode root) {
        if (root == null) return true;

        // Check left child
        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        // Check right child
        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        return isUnivalTreeDFS(root.left) && isUnivalTreeDFS(root.right);
    }

    // BFS Approach
    public boolean isUnivalTreeBFS(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Check left child
            if (node.left != null) {
                if (node.left.val != node.val) return false;
                queue.offer(node.left);
            }

            // Check right child
            if (node.right != null) {
                if (node.right.val != node.val) return false;
                queue.offer(node.right);
            }
        }
        return true; // FIX: Was returning false incorrectly
    }

    public static void main(String[] args) {
        Is_Unival_Tree solution = new Is_Unival_Tree();

        // Sample Tree: All nodes have the same value (Univalued)
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Tree isUnivalTreeDFS: " + solution.isUnivalTreeDFS(root)); 
        System.out.println("Tree isUnivalTreeBFS): " + solution.isUnivalTreeBFS(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(1);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(1);

        System.out.println("Tree isUnivalTreeDFS: " + solution.isUnivalTreeDFS(root1)); 
        System.out.println("Tree isUnivalTreeBFS): " + solution.isUnivalTreeBFS(root1));

    }
}
