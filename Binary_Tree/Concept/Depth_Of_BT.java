/*
Recursive Approach (DFS)

Algorithm
1. If the root is null, return 0 (base case).
2. Recursively calculate the depth of the left and right subtrees.
3. Return 1 + max(leftDepth, rightDepth), since the depth is the longest path from root to leaf.

 */
package Binary_Tree.Concept;

import Core.TreeNode;

public class Depth_Of_BT {


    public static int findDepth(TreeNode root) {
            if (root == null) return 0; // Base case: Empty tree has depth 0
    
            int leftDepth = findDepth(root.left);
            int rightDepth = findDepth(root.right);
    
            return 1 + Math.max(leftDepth, rightDepth);
        }
           
    
        public static void main(String[] args) {
            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(3);
            root1.left.left = new TreeNode(4);
            root1.left.right = new TreeNode(5);
            root1.right.left = new TreeNode(6);
    
            System.out.println("Depth Of Tree? " + findDepth(root1)); // Output: true

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(6);
            root.left.left.left = new TreeNode(7);
    
            System.out.println("Depth of Tree: " + findDepth(root)); // Output: 4


    }
}
