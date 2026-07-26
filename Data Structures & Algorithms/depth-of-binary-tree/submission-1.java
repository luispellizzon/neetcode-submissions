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
    public int maxDepth(TreeNode root) {
        
        return getHeight(root, 1);
    }

    public int getHeight(TreeNode root, int h){
        if(root == null) return h - 1;

        return Math.max(getHeight(root.left, h+1), getHeight(root.right, h+1));
    }
}
