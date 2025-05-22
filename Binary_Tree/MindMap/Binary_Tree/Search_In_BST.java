package Binary_Tree.MindMap.Binary_Tree;

import Utility.TreeNode;

public class Search_In_BST {
    public static TreeNode searchBST(TreeNode root, int val) {
            // Base case: If tree is empty or found the value
             if (root == null || root.val == val) {
                 return root;
             }
             
             // Search in left subtree if val is smaller
             if (val < root.val) {
                 return searchBST(root.left, val);
             } 
             
             // Search in right subtree if val is greater
             return searchBST(root.right, val);
         }
    
         public static void main(String[] args) {
            /*
             * BST Structure:
             *        10
             *       /  \
             *      5   15
             *     / \    \
             *    3   7    18
             */
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.right = new TreeNode(15);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(7);
            root.right.right = new TreeNode(18);
    
            inorder(searchBST(root, 5)); 
            inorder(searchBST(root, 15));

                       
            }
            
            public static void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
}
