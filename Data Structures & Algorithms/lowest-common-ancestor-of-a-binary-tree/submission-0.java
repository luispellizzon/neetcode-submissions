/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    public boolean[] dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || lca != null){
            return new boolean[]{false, false};
        }

        boolean[] left = dfs(root.left, p, q);
        boolean[] right = dfs(root.right, p, q);

        boolean foundP = left[0] || right[0] || root == p;
        boolean foundQ = left[1] || right[1] || root == q;

        if(foundP && foundQ && lca == null){
            lca = root;
        }

        return new boolean[]{foundP, foundQ};
    } 
}