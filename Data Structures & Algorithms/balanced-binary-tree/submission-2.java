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
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        int diffHeight = Math.abs(left - right);

        if(diffHeight > 1){
            isBalanced = false;
        }

        return 1+ Math.max(left, right);
    }
}
