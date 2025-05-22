package Binary_Tree.Technique_Saga;

import Utility.TreeNode;

public class Check_Sibling {
    public static boolean areSiblings(TreeNode root, int a, int b) {
        if (root == null) return false;

        if (root.left != null && root.right != null) {
            if ((root.left.val == a && root.right.val == b) || 
                (root.left.val == b && root.right.val == a)) {
                return true;
            }
        }
        
        return areSiblings(root.left, a, b) || areSiblings(root.right, a, b);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(areSiblings(root, 4, 5)); // true
        System.out.println(areSiblings(root, 4, 6)); // false
    }
}
