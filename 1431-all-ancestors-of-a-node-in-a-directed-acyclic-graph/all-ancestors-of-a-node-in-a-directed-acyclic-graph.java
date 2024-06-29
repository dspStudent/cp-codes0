class Solution {
    List<List<Integer>>a;
    List<List<Integer>>ans;
    private void f(int i, int j, boolean vis[]){
        if(vis[i]){
            System.out.println(i+" ");
            return;
        }
        vis[i]=true;
        for(int node:a.get(i)){
            if(vis[node])continue;
            
            ans.get(node).add(j);
            f(node, j, vis);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        a=new ArrayList<>();ans=new ArrayList<>();
        for(int i=0;i<n;i++){a.add(new ArrayList<>());ans.add(new ArrayList<>());}
        for(int ed[]:edges){
            int x=ed[0], y=ed[1];
            a.get(x).add(y);
        }
        for(int i=0;i<n;i++){
            f(i, i, new boolean[n]);
        }
        return ans;
    }
}