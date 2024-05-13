class Solution {
    private ArrayList<ArrayList<Integer>>adj;
    private boolean vis[];
    private int low[];
    private int time[];
    private List<List<Integer>>ans;
    private void dfs(int i, int par, int c){
        vis[i]=true;
        time[i]=c;
        low[i]=c;
        for(int node : adj.get(i)){
            if(node == par)continue;
            if(vis[node])low[i]=Math.min(low[node], low[i]);
            else{
                dfs(node, i, c+1);
                low[i]=Math.min(low[i], low[node]);
                if(low[node]>time[i]){
                    ArrayList<Integer>a=new ArrayList<>();
                    a.add(i);a.add(node);
                    ans.add(a);
                }
            }
        }
        
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj=new ArrayList<>();
        vis=new boolean[n];
        low=new int[n];
        time=new int[n];
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(List<Integer> i:connections){
            int x=i.get(0), y=i.get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        // for(int i=0;i<n;i++)
        // if(!vis[i])
        ans=new ArrayList<>();
        dfs(0, -1, 1);
        
        // for(List<Integer> i:connections){
        //     int x=i.get(0), y=i.get(1);
        //     if(low[x]==low[y])continue;
        //     List<Integer>a=new ArrayList<>();
        //     a.add(x);a.add(y);
        //     ans.add(a);
        // }
        return ans;
        
    }
}