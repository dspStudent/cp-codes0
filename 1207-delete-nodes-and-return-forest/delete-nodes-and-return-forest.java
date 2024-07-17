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
    Set<TreeNode>set=new HashSet<>();
    List<TreeNode>nodes;
    private void getAllNodes(TreeNode root){
        if(root==null)return;
        nodes.add(root);
        getAllNodes(root.left);
        getAllNodes(root.right);
    }
    private void dfs(TreeNode root, Set<Integer>del){
        if(root==null || set.contains(root))return;
        set.add(root);
        if(root.left!=null){
            if(del.contains(root.left.val)){
                set.add(root.left);
                root.left=null;
            }
        }
        if(root.right!=null){
            if(del.contains(root.right.val)){
                set.add(root.right);
                root.right=null;
            }
        }
        dfs(root.left, del);
        dfs(root.right, del);
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode>comp=new ArrayList<>();
        Set<Integer>del=new HashSet<>();
        for(int i:to_delete)del.add(i);
        nodes=new ArrayList<>();
        getAllNodes(root);
        for(int i=0;i<nodes.size();i++){
            if(!set.contains(nodes.get(i))){
                if(del.contains(nodes.get(i).val)){
                    set.add(nodes.get(i));
                    // comp.add(null);
                    continue;
                }
                comp.add(nodes.get(i));
                dfs(nodes.get(i), del);
            }
        }
        return comp;
    }
}