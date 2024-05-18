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
    private int steps=0;
    private int dfs(TreeNode root){
        if(root==null)return 0;
        int leftReq=dfs(root.left);
        int rightReq=dfs(root.right);
        steps+=Math.abs(leftReq)+Math.abs(rightReq);
        return (root.val-1)+ leftReq+ rightReq;
    }
    public int distributeCoins(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return steps;
    }
}