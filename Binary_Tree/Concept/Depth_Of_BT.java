/*
Recursive Approach (DFS)

Algorithm
1. If the root is null, return 0 (base case).
2. Recursively calculate the depth of the left and right subtrees.
3. Return 1 + max(leftDepth, rightDepth), since the depth is the longest path from root to leaf.

 */
package Binary_Tree.Concept;

import Core.TreeNode;
import java.util.*;

public class Depth_Of_BT {

    public static int findDeptWithDFS(TreeNode root) {
        if (root == null)
            return 0; // Base case: Empty tree has depth 0

        int leftDepth = findDeptWithDFS(root.left);
        int rightDepth = findDeptWithDFS(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static int findDeptWithBFS(TreeNode root) {
        if (root == null)
            return 0; // Base case: Empty tree has depth 0

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i =0; i< size; i++)
            {
                TreeNode node = queue.poll(); // Poll inside the loop

                if(node.left != null)
                {
                    queue.offer(node.left);
                }

                if(node.right != null)
                {
                    queue.offer(node.right);
                }
                
            }

            maxDepth++;

        }

        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);

        System.out.println("Depth Of Tree DFS " + findDeptWithDFS(root1)); // Output: true
        System.out.println("Depth Of Tree BFS " + findDeptWithBFS(root1)); // Output: true


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println("Depth of Tree DFS " + findDeptWithDFS(root)); // Output: 4
        System.out.println("Depth Of Tree BFS " + findDeptWithBFS(root)); // Output: true


    }

}
