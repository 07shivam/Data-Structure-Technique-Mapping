package Binary_Tree.Technique_Saga;

import java.util.LinkedList;
import java.util.Queue;

import Utility.TreeNode;

public class Check_Cousin {

     public static boolean check_if_cousion(TreeNode root, int x, int y) {

        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int parentCount = 0;
        int childCount = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            childCount = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                parentCount = 0;
                
                if (node.left != null)
                {
                    if(node.left.val == x || node.left.val == y)
                    {
                        parentCount++;
                        childCount++;
                    }
                    queue.offer(node.left);
                }

                if (node.right != null)
                {
                    if(node.right.val == x || node.right.val == y)
                    {
                        parentCount++;
                        childCount++;
                    }
                    queue.offer(node.right);
                }

                if(parentCount == 2)
                {
                    return false;
                }
            }
            if(childCount == 2)
            {
                return true;
            }
            if(childCount == 1)
            {
                return false;
            }
        }

        return false;
    }

    public static boolean check_if_cousin(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean foundX = false, foundY = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Check if x and y are children of the same parent
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false; // They have the same parent, so they are not cousins
                    }
                }

                // Mark if x or y is found at the current level
                if (node.left != null) {
                    if (node.left.val == x) foundX = true;
                    if (node.left.val == y) foundY = true;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    if (node.right.val == x) foundX = true;
                    if (node.right.val == y) foundY = true;
                    queue.offer(node.right);
                }
            }

            // If both nodes are found at the same level and have different parents
            if (foundX && foundY) return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        /*
         * Tree Structure:
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(check_if_cousion(root, 4, 5)); 
        System.out.println(check_if_cousion(root, 4, 6)); 
    }
}
