package Binary_Tree.Technique_Saga;

import java.util.LinkedList;
import java.util.Queue;

import Utility.TreeNode;

public class Insert_Node {

    public TreeNode insertIntoBinaryTree(TreeNode root, int val) {
        if(root == null)
        {
            return root;
        }
        TreeNode head = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if(node.left == null)
                {
                    node.left = new TreeNode(val);
                    return head;
                }

                if(node.right == null)
                {
                    node.right = new TreeNode(val);
                    return head;
                }

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        TreeNode current = root;
        
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(val); 
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        
        return root;
    }
}
