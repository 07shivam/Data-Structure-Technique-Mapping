/*Binary Tree Zigzag Level Order Traversal means traversing the tree level by level, but alternating the direction at each level.

Left to right at one level
Right to left at the next level
Repeat until all levels are covered */
package Binary_Tree.Technique_Saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Core.TreeNode;

public class Zig_Zag_Traversals {
    public static void zigZag_Traversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return ;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean toggle = true;
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            if(!toggle)
            {
                Collections.reverse(level);
            }

            System.out.println(level);

            result.add(level);
            toggle =! toggle;
        }
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

        System.out.println("\n reverseLevelOrder (Recursive): ");

        zigZag_Traversal(root);
        
    }
}
