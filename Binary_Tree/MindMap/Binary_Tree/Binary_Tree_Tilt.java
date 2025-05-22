/*
 *Link : https://leetcode.com/problems/binary-tree-tilt/description/

 Algorithm Explanation: Find Tilt of a Binary Tree
- The given algorithm calculates the tilt of a binary tree. The tilt of a node is defined as the absolute difference between the sum of values of its left and right subtrees. The goal is to find the sum of tilts of all nodes in the tree.

Step-by-Step Dry Run
Key Variables:
totalTilt: Stores the cumulative tilt of all nodes.

calculateSum(TreeNode root): Recursively computes subtree sums and tilt values.

Algorithm Breakdown
Base Case (Leaf Node Handling)

If root == null, return 0, since a null node has no sum.

Recursive Sum Calculation

Recursively calculate the sum of the left subtree: int leftSum = calculateSum(root.left);

Recursively calculate the sum of the right subtree: int rightSum = calculateSum(root.right);

Calculate Tilt for Current Node

nodeTilt = Math.abs(leftSum - rightSum);

Add this nodeTilt to totalTilt.

Return the Total Sum of the Subtree

return root.val + leftSum + rightSum;

This helps the parent node calculate its tilt.

Dry Run Example
Tree Structure
markdown
Copy
Edit
        1
       / \
      2   3
     / \   \
    4   5   6
Recursive Execution
Leaf Nodes Calculation:

calculateSum(4) → return 4 (tilt = 0)

calculateSum(5) → return 5 (tilt = 0)

calculateSum(6) → return 6 (tilt = 0)

Internal Nodes Calculation:

Node 2:

leftSum = 4, rightSum = 5

tilt = |4 - 5| = 1

totalTilt = 1

Returns 2 + 4 + 5 = 11

Node 3:

leftSum = 0, rightSum = 6

tilt = |0 - 6| = 6

totalTilt = 1 + 6 = 7

Returns 3 + 0 + 6 = 9

Root Node Calculation (Node 1):

leftSum = 11, rightSum = 9

tilt = |11 - 9| = 2

totalTilt = 7 + 2 = 9

Returns 1 + 11 + 9 = 21

Final Result
totalTilt = 9

Output: 9

Time & Space Complexity
Time Complexity: O(n) (Each node is visited once)

Space Complexity: O(h), where h is the height of the tree (due to recursion stack in DFS).


 */
package Binary_Tree.MindMap.Binary_Tree;

import Utility.TreeNode;

public class Binary_Tree_Tilt {
    
    private int totalTilt = 0; 

    public int findTilt(TreeNode root) {
         calculateSum(root); // Helper function to calculate the tilt
        return totalTilt; 
    }

    private int calculateSum(TreeNode root) {
        if (root == null) {
            return 0; // If node is null, sum is 0
        }

        int leftSum = calculateSum(root.left);  // Sum of left subtree
        int rightSum = calculateSum(root.right); // Sum of right subtree

        int nodeTilt = Math.abs(leftSum - rightSum); // Tilt of current node
        totalTilt += nodeTilt; // Add current node tilt to total tilt

        return root.val + leftSum + rightSum; //  returning the total sum of the subtree rooted at the current node.Each parent node needs to calculate its own tilt, which is based on the sum of its left and right subtrees.
    }
    
}
