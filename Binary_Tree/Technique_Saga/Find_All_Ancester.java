/*Approach
Base Case:

If the root is null, return false.
If the root matches the target node, return true (we found the node).
Recursive Calls:

Recursively search for the target node in the left and right subtrees.
Store Ancestors:

If the target node is found in either subtree, add the current node to the ancestor list.
Stop when found:

Once we find the target, we stop searching further.
 */
package Binary_Tree.Technique_Saga;

import java.util.ArrayList;
import java.util.List;

import Utility.TreeNode;

public class Find_All_Ancester {

    public static boolean findAncestors(TreeNode root, int target, List<Integer> ancestors) {
        if (root == null) {
            return false;
        }

        // If the target node is found, return true
        if (root.val == target) {
            return true;
        }

        // Check in left or right subtree
        if (findAncestors(root.left, target, ancestors) || findAncestors(root.right, target, ancestors)) {
            ancestors.add(root.val); // Add current node to ancestor list
            return true;
        }

        return false;
    }

     public static void main(String[] args) {
        /*
         * Tree Structure:
         *        1
         *       / \
         *      2   3
         *     / \   \
         *    4   5   6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int target = 4;
        List<Integer> ancestors = new ArrayList<>();
        findAncestors(root, target, ancestors);

        System.out.println("Ancestors of " + target + ": " + ancestors);
    }

}
