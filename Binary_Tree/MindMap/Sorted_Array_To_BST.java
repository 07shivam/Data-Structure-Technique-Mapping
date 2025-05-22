/*
Convert Sorted Array to Binary Search Tree

- Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
package Binary_Tree.MindMap;

import Utility.TreeNode;

public class Sorted_Array_To_BST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createBst(0, nums.length - 1, nums); // Fix the end index
    }

    public static TreeNode createBst(int start, int end, int[] nums) {
        if (start > end) { // Fix the base case
            return null;
        }

        int mid = start + (end - start) / 2; // Prevent overflow
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBst(start, mid - 1, nums);
        root.right = createBst(mid + 1, end, nums);
        return root;
    }

    // Inorder traversal to print the BST (Left, Root, Right)
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 }; // Example sorted array

        TreeNode root = sortedArrayToBST(nums);

        // Print inorder traversal (should be sorted)
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
    }
}
