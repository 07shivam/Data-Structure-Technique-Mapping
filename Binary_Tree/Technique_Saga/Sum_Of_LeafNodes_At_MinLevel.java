/*Example Binary Tree
markdown
Copy
Edit
        10
       /  \
      20   30
     / \     \
    40  50    60
   /
  70
Step-by-Step Level Order Traversal
Level	Nodes at this Level	Leaf Nodes?	Sum (If Leaf Exists)
1	10	❌ No	—
2	20, 30	❌ No	—
3	40, 50, 60	✅ Yes (50, 60)	50 + 60 = 110
 */
package Binary_Tree.Technique_Saga;

import java.util.LinkedList;
import java.util.Queue;

import Core.TreeNode;

public class Sum_Of_LeafNodes_At_MinLevel {
    public static int sumOfLeafNodesAtMinLevel(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            boolean leafFound = false;

            // Process nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Check if it's a leaf node
                if (node.left == null && node.right == null) {
                    sum += node.val;
                    leafFound = true;
                }

                // Add children to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // If we found leaf nodes at this level, return their sum
            if (leafFound) return sum;
        }

        return 0;  // This case is never reached (since at least one leaf will be present)
    }

    public static int sumOfLeafNodes(TreeNode root) {
        if (root == null) return 0;

        // If the node is a leaf node, return its value
        if (root.left == null && root.right == null) return root.val;

        // Otherwise, recurse for left and right subtrees
        return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
    }

    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        root.left.left.left = new TreeNode(70);

        System.out.println("Sum of leaf nodes at the minimum level: " + sumOfLeafNodesAtMinLevel(root));
    }
}
