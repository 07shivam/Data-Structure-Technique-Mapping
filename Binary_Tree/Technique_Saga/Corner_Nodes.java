/*1️⃣ Printing Corner Nodes in a Binary Tree and Binary Search Tree, same approach for both
Approach:
1. Perform Level Order Traversal (BFS) using a queue.
2. Identify first and last node of each level.
3. Print the first and last nodes for each level.
 */

package Binary_Tree.Technique_Saga;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Utility.TreeNode;

public class Corner_Nodes {
    public static void printCornerNodes(TreeNode root) {

        if (root == null)
            return;
            Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            System.out.print(list.get(0));
            if(list.get(list.size()-1) != list.get(0))
            {
                System.out.print( " " + list.get(list.size()-1));
            }
            System.out.println();



        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);

        System.out.println("Corner Nodes of the Binary Tree:");
        printCornerNodes(root);
    }
}
