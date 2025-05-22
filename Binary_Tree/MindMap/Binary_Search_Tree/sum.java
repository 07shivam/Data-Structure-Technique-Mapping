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

import Utility.TreeNode;
import java.util.*;

class Solution {

    public int binaryConversion(int number) {
        int dec = 0;
        int base = 1; // Fixed base initialization

        while (number != 0) {
            int lastDigit = number % 10;
            number = number / 10;

            dec += lastDigit * base; // Fixed multiplication logic
            base *= 2; // Corrected base update
        }

        return dec;

    }

    public int sumRootToLeaf(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int totalSum = 0;
        String current = "";

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            current +=  node.val.toString(); 
            
            if(node.left == null && node.right == null)
            {
                totalSum += binaryConversion(Integer.parseInt(current));
                current = "";
            }

            if(node.left != null)
            {
                queue.add(node.left);
            }
            if(node.right != null)
            {
                queue.add(node.right);
            }
        }

        return totalSum;
    }

}