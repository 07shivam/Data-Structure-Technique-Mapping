/*Base Case:

If the root is null, return null.
If the root is equal to p or q, return the root (one of the targets found).
Recursive Calls:

Recursively search for p and q in the left and right subtrees.
Decision:

If both left and right return non-null values, the current node is the LCA.
If only one side returns a non-null value, return that value (one target is found deeper).
If both sides return null, return null (no LCA in this subtree).
 */
package Binary_Tree.Technique_Saga;

import Core.TreeNode;

public class Lowest_Common_Ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

       // matches p or q
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftStr = lowestCommonAncestor(root.left, p, q);
        TreeNode rightStr = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, current node is LCA
        if (leftStr != null && rightStr != null) {
            return root;
        }

        // Otherwise, return the non-null side
        return (leftStr != null) ? leftStr : rightStr;

    }
}
