//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    private boolean vis[];
    private Stack<Integer>st;
    private ArrayList<ArrayList<Integer>> radj;
    private void dfs(int i, int par, ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        for(int node:adj.get(i)){
            if(node == par)continue;
            if(vis[node])continue;
            dfs(node, i, adj);
        }
        st.push(i);
    }
    private void rdfs(int i, int par){
        vis[i]=true;
        for(int node:radj.get(i)){
            if(node == par)continue;
            if(vis[node])continue;
            rdfs(node, i);
        }
    }
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        vis=new boolean[n];
        st=new Stack<>();
        radj=new ArrayList<>();
        for(int i=0;i<n;i++)if(vis[i]==false)dfs(i, -1, adj);
        Arrays.fill(vis, false);
        for(int i=0;i<n;i++)radj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                radj.get(adj.get(i).get(j)).add(i);
            }
        }
        // System.out.println(adj);
        // System.out.println(radj);
        int c=0;
        Arrays.fill(vis, false);
        // System.out.println(st);
        while(!st.isEmpty()){
          int i=st.peek();
          if(vis[i]==false){rdfs(i, -1);c++;}
          else st.pop();
        }
        return c;
    }
}
