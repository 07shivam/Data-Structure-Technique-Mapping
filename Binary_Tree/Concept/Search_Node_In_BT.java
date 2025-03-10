/*
Recursive Approach (DFS)

Algorithm
1. If the root is null, return 0 (base case).
2. Recursively calculate the depth of the left and right subtrees.
3. Return 1 + max(leftDepth, rightDepth), since the depth is the longest path from root to leaf.

 */
package Binary_Tree.Concept;
import Core.TreeNode;


public class Search_Node_In_BT {


    public static boolean searchNode(TreeNode root,  int target) {
            if (root == null) return false; 
    
            if (root.val == target) return true; // Node found

            // Recursively search in left and right subtrees
            return searchNode(root.left, target) || searchNode(root.right, target);
        }
           
    
        public static void main(String[] args) {
           
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(searchNode(root, 5)); // Output: true
        System.out.println(searchNode(root, 7)); // Output: false


    }
}
