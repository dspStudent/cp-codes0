//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class DisjointSetUnion {
    int djs[];
    int rank[];
    int size[];
    int max;
    DisjointSetUnion(int max){
        this.max=max;
        djs=new int[max];
        rank=new int[max];
        size=new int[max];
        Arrays.fill(rank, 0);
        Arrays.fill(size, 1);
        for(int i=0;i<max;i++){
            djs[i]=i;
        }
    }
    public int supParent(int x){
        if(x==djs[x])return x;
        return djs[x]=supParent(djs[x]);
    }
    private boolean isComponet(int x, int y){
        return djs[x]==djs[y];
    }
    public void addUniByRank(int x, int y){
        int parx=supParent(x);
        int pary=supParent(y);
        if(parx==pary)return;
        if(rank[parx]==rank[pary]){
            djs[pary]=djs[parx];
            rank[parx]++;
        }
        else if(rank[parx]<rank[pary]){
            djs[parx]=djs[pary];
        }
        else{
            djs[pary]=djs[parx];
        }
    }
    public void addUniBySize(int x, int y){
        int parx=supParent(x);
        int pary=supParent(y);
        if(parx==pary)return;
        if(size[parx] > size[pary]){
            djs[pary]=parx;
            size[parx]+=size[pary];
        }
        else{
            djs[parx]=pary;
            size[pary]+=size[parx];
        }
    }
}
class Solution{
     private int h(int [][]grid, int m, int n, DisjointSetUnion ds){
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                int s=0;
                if(grid[i][j]==1)continue;
                //  all sides
                if(i-1>=0 && j-1>=0 && i+1<m && j+1<n){
                    int down=ds.supParent((i+1)*n+j),up=ds.supParent((i-1)*n+j);
                    int left=ds.supParent((i)*n+j-1),right=ds.supParent((i)*n+j+1);
                    if(grid[i+1][j]==1){
                        s+=ds.size[down];
                    }
                    if(grid[i-1][j]==1 && down!=up){
                        s+=ds.size[up];
                    }
                    if(grid[i][j+1]==1 && right!=down && right!=up){
                        s+=ds.size[right];
                    }
                    if(grid[i][j-1]==1 && left!=right && left!=down && left!=up){
                        s+=ds.size[left];
                    }
                }//only left up right
                else if(i-1>=0 && j-1>=0 && j+1<n){
                    // System.out.println(i+" "+j);
                    int up=ds.supParent((i-1)*n+j);
                    int left=ds.supParent((i)*n+j-1),right=ds.supParent((i)*n+j+1);
                    if(grid[i-1][j]==1){
                        s+=ds.size[up];
                    }
                    if(grid[i][j+1]==1  && right!=up){
                        s+=ds.size[right];
                    }
                    if(grid[i][j-1]==1 && left!=right && left!=up){
                        s+=ds.size[left];
                    }
                }//only left down right
                else if(i+1<m && j-1>=0 && j+1<n){
                    int down=ds.supParent((i+1)*n+j);
                    int left=ds.supParent((i)*n+j-1),right=ds.supParent((i)*n+j+1);
                    if(grid[i+1][j]==1){
                        s+=ds.size[down];
                    }
                    if(grid[i][j+1]==1 && right!=down){
                        s+=ds.size[right];
                    }
                    if(grid[i][j-1]==1 && left!=right && left!=down){
                        s+=ds.size[left];
                    }
                }//only up right down
                else if(i-1>=0 && i+1<m && j+1<n){
                    int down=ds.supParent((i+1)*n+j),up=ds.supParent((i-1)*n+j);
                    int right=ds.supParent((i)*n+j+1);
                    if(grid[i+1][j]==1){
                        s+=ds.size[down];
                    }
                    if(grid[i-1][j]==1 && down!=up){
                        s+=ds.size[up];
                    }
                    if(grid[i][j+1]==1 && right!=down && right!=up){
                        s+=ds.size[right];
                    }
                }//only up left down
                else if(i-1>=0 && j-1>=0 && i+1<m){
                    int down=ds.supParent((i+1)*n+j),up=ds.supParent((i-1)*n+j);
                    int left=ds.supParent((i)*n+j-1);
                    if(grid[i+1][j]==1){
                        s+=ds.size[down];
                    }
                    if(grid[i-1][j]==1 && down!=up){
                        s+=ds.size[up];
                    }
                    if(grid[i][j-1]==1 && left!=down && left!=up){
                        s+=ds.size[left];
                    }
                }// only right down
                else if(i+1<m && j+1<n){
                    int right=ds.supParent((i)*n+j+1),down=ds.supParent((i+1)*n+j);
                    if(grid[i][j+1]==1){
                        s+=ds.size[right];
                    }
                    if(grid[i+1][j]==1 && right!=down){
                        s+=ds.size[down];
                    }
                }// only right up
                else if(i-1>=0 && j+1<n){
                    int right=ds.supParent((i)*n+j+1),up=ds.supParent((i-1)*n+j);
                    if(grid[i][j+1]==1){
                        s+=ds.size[right];
                    }
                    if(grid[i-1][j]==1 && right!=up){
                        s+=ds.size[up];
                    }
                } // only left down
                else if(i+1<m && j-1>=0){
                    int left=ds.supParent((i)*n+j-1),down=ds.supParent((i+1)*n+j);
                    if(grid[i][j-1]==1){
                        s+=ds.size[left];
                    }
                    if(grid[i+1][j]==1 && left!=down){
                        s+=ds.size[down];
                    }
                }// only left up
                else if(i-1<m && j-1>=0){
                    int left=ds.supParent((i)*n+j-1),up=ds.supParent((i-1)*n+j);
                    if(grid[i][j-1]==1){
                        s+=ds.size[left];
                    }
                    if(grid[i-1][j]==1 && left!=up){
                        s+=ds.size[up];
                    }
                }
                s++;
                ans=Math.max(ans, s);
            }
            
        }
        return ans==0?m*n:ans;
    }
    public int MaxConnection(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        if(m*n==1)return 1;
        DisjointSetUnion ds=new DisjointSetUnion(m*n);
        boolean vis[]=new boolean[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                int node=i*n+j;
                if(vis[node])continue;
                if(i-1 >=0){
                    if(grid[i-1][j]==1 && ds.supParent(node)!=ds.supParent((i-1)*n+j))
                    ds.addUniBySize( (i-1)*n+j, node);
                }
                if(j-1>=0){
                    if(grid[i][j-1]==1 && ds.supParent(node)!=ds.supParent((i)*n+j-1))
                    ds.addUniBySize( (i)*n+j-1, node);
                }
                if(j+1<n){
                    if(grid[i][j+1]==1 && ds.supParent(node)!=ds.supParent((i)*n+j+1))
                    ds.addUniBySize( (i)*n+j+1, node);
                }
                if(i+1<m){
                    if(grid[i+1][j]==1 && ds.supParent(node)!=ds.supParent((i+1)*n+j))
                    ds.addUniBySize( (i+1)*n+j, node);
                }
            }
        }
        // System.out.println(Arrays.toString(ds.djs));
        return h(grid, m, n, ds);
    }
}