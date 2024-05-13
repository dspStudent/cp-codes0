//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    private int c;
    private boolean vis[];
    private int low[];
    private int time[];
    private List<List<Integer>>ans;
    private HashSet<Integer>set;
    private void dfs(int i, int par, ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        low[i]=c;
        time[i]=c;
        int child=0;
        c++;
        for(int node : adj.get(i)){
            if(node==par)continue;
            
            if(vis[node])low[i]=Math.min(time[node], low[i]);
            else{
                
                dfs(node, i, adj);
                low[i]=Math.min(low[i], low[node]);
                // System.out.println("node: "+node+" i: "+i+" par: "+par);
                if(low[node]>=time[i] && par!=-1){
                    // System.out.println("in---"+"node: "+node+" i: "+i+" par: "+par);
                    // System.out.print(node);
                   set.add(i); 
                   
                }child++;
            }
            
        }
        if(child>1 && par==-1)set.add(i);
       
    }
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        vis=new boolean[n];
        low=new int[n];
        time=new int[n];
        set=new HashSet<>();
        c=1;
        for(int i=0;i<n;i++){
        if(vis[i]==false)
        dfs(i, -1, adj);
        }
        // if(adj.get(0).size()>1)set.add(0);
        
        ArrayList<Integer>a=new ArrayList<>(set);
        // return a;
        Collections.sort(a);
        return a.size()==0?new ArrayList<>(Arrays.asList(-1)):a;
    }
}