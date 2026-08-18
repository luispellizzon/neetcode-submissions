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
    private List<TreeNode> sequence = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        traversal(root);
        TreeNode found1 = null;
        TreeNode found2 = null;
        TreeNode prev = null;
        for(int i = 0; i < sequence.size(); i++){
            TreeNode current = sequence.get(i);

            if(prev != null && prev.val > current.val){
                if(found1 == null){
                    found1 = prev;
                    found2 = current;
                }
                else {
                    found2 = current;
                    break;
                }
            }

            prev = current;
        }

        int temp = found1.val;
        found1.val = found2.val;
        found2.val = temp;

    }

    private void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        sequence.add(root);
        traversal(root.right);
    }
}