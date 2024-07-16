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
    Map<Integer, int[]>map;
    public void getAdj(TreeNode root, TreeNode par){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            map.put(root.val, new int[]{-1, -1, par.val});
        }
        int left=-1,right=-1, up=-1;
        left=root.left==null?-1:root.left.val;
        right=root.right==null?-1:root.right.val;
        up=par==null?-1:par.val;
        map.put(root.val, new int[]{left, right, up});
        getAdj(root.left, root);
        getAdj(root.right, root);
    }
    StringBuilder sb=new StringBuilder();
    boolean vis[];
    public boolean getAns(int s, int t){
        if(s==t){
            return true;
        }
        
        vis[s]=true;
        int i[]=map.get(s);
        boolean left=false, right=false, up=false;
        if(i[0]!=-1 && !vis[i[0]])
        left=getAns(i[0], t);
        if(i[1]!=-1 && !vis[i[1]])
        right=getAns(i[1], t);
        if(i[2]!=-1 && !vis[i[2]])
        up=getAns(i[2], t);

        if(left)sb.append("L");
        if(right)sb.append("R");
        if(up)sb.append("U");

        return left || right || up;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        map=new HashMap<>();
        getAdj(root, null);
        // for(int i:map.keySet()){
        //     System.out.println(i+" "+Arrays.toString(map.get(i)));
        // }
        vis=new boolean[map.size()+1];
         getAns(startValue, destValue);
         return sb.reverse().toString();
    }
}
