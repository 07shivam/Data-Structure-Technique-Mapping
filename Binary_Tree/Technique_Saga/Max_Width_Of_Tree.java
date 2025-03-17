package Binary_Tree.Technique_Saga;

import java.util.LinkedList;
import java.util.Queue;

import Core.TreeNode;
import javafx.util.Pair;

public class Max_Width_Of_Tree {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0)); // (node, index)
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int firstIndex = queue.peek().getValue();  // Leftmost node index
            int lastIndex = firstIndex;  // Initialize lastIndex
            
            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                int index = current.getValue() - firstIndex;  // Normalize index
                
                if (i == levelSize - 1) lastIndex = index; // Update lastIndex
                
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, index * 2 + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, index * 2 + 2));
                }
            }
            
            maxWidth = Math.max(maxWidth, lastIndex + 1);
        }
        
        return maxWidth;
    }
}
}
