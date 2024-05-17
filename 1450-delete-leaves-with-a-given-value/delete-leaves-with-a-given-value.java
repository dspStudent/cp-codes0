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
    private void f(TreeNode root, int k){
        if(root==null)return ;
        f(root.left, k);
        f(root.right, k);
        if(root.left!=null){
            TreeNode rl=root.left;
            if(rl.left==null && rl.right==null && rl.val==k)root.left=null;
        }
        if(root.right!=null){
            TreeNode rl=root.right;
            if(rl.left==null && rl.right==null && rl.val==k)root.right=null;
        }
        
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        f(root, target);
        if(root.left==null && root.right==null && root.val==target)return null;
        return root;
    }
}