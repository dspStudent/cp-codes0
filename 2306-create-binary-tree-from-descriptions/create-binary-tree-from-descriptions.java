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
    private int getMeRootNode (int [][]de){
        HashSet<Integer>set=new HashSet<>();
        for(int i[]:de){
            set.add(i[1]);
        }
        for(int i[]:de){
            if(!set.contains(i[0]))return i[0];
        }
        return 0;
    }

    TreeNode ansRoot;

    private void makeTree(TreeNode root, int node,  HashMap<Integer,List<int[]>>map){
        if(!map.containsKey(node))return;

        // System.out.println(node);

        root.val=node;
        

        List<int[]>nodes=map.get(node);

        int first[]=nodes.get(0);
        int sec[]=new int[]{-1, -1};

        if(nodes.size()>1)
        sec=nodes.get(1);

        int leftNode=0, rightNode=0;

        if(sec[0]==-1){
            if(first[1]==1){
                leftNode=first[0];
                root.left=new TreeNode(leftNode);
                makeTree(root.left, leftNode, map);
            }
            else{
                rightNode=first[0]; 
                root.right=new TreeNode(rightNode);
                makeTree(root.right, rightNode, map);
            }
            return;
        }

        leftNode=first[1]==1?first[0]:sec[0];
        rightNode=first[1]==0?first[0]:sec[0];
        root.left=new TreeNode(leftNode);
        root.right=new TreeNode(rightNode);
        makeTree(root.left, leftNode, map);
        makeTree(root.right, rightNode, map);
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,List<int[]>>map=new HashMap<>();
        for(int i[]:descriptions){
            int a=i[0], b=i[1], c=i[2];
            map.put(a, map.getOrDefault(a, new ArrayList<>()));
            map.get(a).add(new int[]{b, c});
        }
        int rootN=getMeRootNode(descriptions);
        // System.out.println(root);
        ansRoot=new TreeNode(0);
        makeTree(ansRoot, rootN, map);
        return ansRoot;
    }
}