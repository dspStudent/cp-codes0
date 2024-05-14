class Solution {
    private int dfs(int i, int j, int [][]grid, boolean vis[][], int a, int b){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length 
        || vis[i][j] || grid[i][j]==0)return 0;
        vis[i][j]=true;
        int dr[]={-1, 1, 0, 0};
        int dc[]={0, 0, -1, 1};
        int max=-1;
        for(int it=0;it<4;it++){
            int r=i+dr[it], c=j+dc[it];
            max=Math.max(max, grid[i][j]+dfs(r, c, grid, vis, a, b));
        }
        vis[i][j]=false;
        return max;
    }
    public int getMaximumGold(int[][] grid) {
        int max=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    max=Math.max(max, dfs(i, j, grid,
                     new boolean[grid.length][grid[0].length], i, j));
                }
            }
        }
        return max==-1?0:max;
    }
}