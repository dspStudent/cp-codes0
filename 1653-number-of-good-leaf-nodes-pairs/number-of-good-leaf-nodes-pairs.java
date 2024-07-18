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
    // Map<TreeNode,List<TreeNode>>map; 
    // Set<TreeNode>set;
    Map<TreeNode, TreeNode>parMap;
    Map<TreeNode, Integer>dept;
    // public void getAdj(TreeNode cur, TreeNode par){
    //     if(cur==null)return;

    //     map.put(cur, new ArrayList<>());

    //     if(par!=null)
    //     map.get(cur).add(par);

    //     if(cur.left!=null)
    //     map.get(cur).add(cur.left);

    //     if(cur.right!=null)
    //     map.get(cur).add(cur.right);

    //     getAdj(cur.left, cur);
    //     getAdj(cur.right, cur);
    // }
    // public void printMap(){
    //     for(TreeNode i:map.keySet()){
    //         System.out.print(i.val+" -> ");
    //         for(TreeNode j:map.get(i)){
    //             System.out.print(j.val+" ");
    //         }
    //         System.out.println();
    //     }
    // }
    
    public void getDp(TreeNode root, TreeNode par, int dep){
        if(root==null)return;
        if(root.left==null && root.right==null){
            leaf.add(root);
            parMap.put(root, par);
            dept.put(root, dep);
            return;
        }
        parMap.put(root, par);
        dept.put(root, dep);
        getDp(root.left, root, dep+1);
        getDp(root.right, root, dep+1);
    }
    List<TreeNode>leaf;
    public int getDis(TreeNode left, TreeNode right){
        int ld=dept.get(left), rd=dept.get(right);
        if(rd>ld)return getDis(right, left);
        int count=0;
        while(ld>rd){
            count++;
            left=parMap.get(left);
            ld=dept.get(left);
        }
        TreeNode parl=parMap.get(left), parR=parMap.get(right);
        count+=2;
        while(parl!=parR){
            parl=parMap.get(parl);
            parR=parMap.get(parR);
            count+=2;
        }
        return count;
    }
// 0
// 1
// 1
// 1
// 1
// 0
    public int countPairs(TreeNode root, int distance) {
        // map=new HashMap<>();
        // getAdj(root, null);
        parMap=new HashMap<>();
        dept=new HashMap<>();
        leaf=new ArrayList<>();
        // set=new HashSet<>();
        getDp(root, null, 1);
        // System.out.println(leaf);
        int n=leaf.size(), count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sd=getDis(leaf.get(i), leaf.get(j));
                if( sd<= distance)count++;
                // System.out.println(sd);
            }
        }
        return count;
    }
}