package Binary_Tree.Concept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Utility.TreeNode;

public class Search_Max_Min_BT {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxVal = Math.max(maxVal, node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(maxVal);
        }

        return result;
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;

        long secondMin = Long.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minVal = root.val; // Smallest value is at the root

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val > minVal && node.val < secondMin) {
                secondMin = node.val;
            }
            /*
             * node.val > minVal:
             * 
             * Ensures that we are looking for a value greater than the smallest value
             * (minVal).
             * Since root.val = min(root.left.val, root.right.val), the smallest value is
             * always at the root.
             * node.val < secondMin:
             * 
             * Ensures that we are updating secondMin only if we find a smaller value than
             * the current secondMin.
             */

            if (node.left != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    // Search for a node in BST
    public static TreeNode searchBST(TreeNode root, int val) {
        // Base case: If tree is empty or value is found
        if (root == null || root.val == val) {
            return root;
        }

        // Search in left subtree if val is smaller
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // Search in right subtree if val is greater
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        // Creating a BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int searchVal1 = 2;
        TreeNode result1 = searchBST(root, searchVal1);
        printTree(result1);
        System.out.println();

        System.out.println("Is " + searchVal1 + " found in BST? " + (result1 != null)); // Output: true

        System.out.println();
        int searchVal2 = 5;
        TreeNode result2 = searchBST(root, searchVal2);
        printTree(result2);
        System.out.println();

        System.out.println("Is " + searchVal2 + " found in BST? " + (result2 != null)); // Output: false

    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " "); // Print current node
        printTree(root.left); // Recur for left subtree
        printTree(root.right); // Recur for right subtree
    }
}
