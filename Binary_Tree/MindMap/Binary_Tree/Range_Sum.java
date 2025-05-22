/*
Range Sum of BST
Link : https://leetcode.com/problems/range-sum-of-bst/description/ 


Approach : 
1. If root.val < low, skip left and move right.
2. If root.val > high, skip right and move left.
3. Otherwise, add root.val and explore both left & right.

 */
package Binary_Tree.MindMap.Binary_Tree;

import Utility.TreeNode;

public class Range_Sum {
    public static int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
    
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            } else if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            } else {
                return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
            }
        }
    
        public static void main(String[] args) {
            /*
             * BST Structure:
             *        10
             *       /  \
             *      5   15
             *     / \    \
             *    3   7    18
             */
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.right = new TreeNode(15);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(7);
            root.right.right = new TreeNode(18);
    
            int low = 7, high = 15;
            System.out.println("Range Sum: " + rangeSumBST(root, low, high)); // Output: 32
    }
}
