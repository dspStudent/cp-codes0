class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int ans=0;
        PriorityQueue<int[]>q=new PriorityQueue<>((i, j)->i[2]-j[2]);
        q.add(new int[]{0, 0, grid[0][0]});
        boolean vis[][]=new boolean [m][n]; 
        while(!q.isEmpty()){
            int x[]=q.poll();
            int i=x[0],j=x[1],next=x[2];
            if(vis[i][j])continue;
            vis[i][j]=true;
            ans=Math.max(ans, next);
            if(i==m-1 && j==n-1)return ans;
            int dr[]={0, 0, -1, 1};
            int dc[]={1, -1, 0, 0};
            for(int it=0;it<4;it++){
                int r=i+dr[it], c=j+dc[it];
                if(r>=0 && c>=0 && r<m && c<n){
                    q.add(new int[]{r, c, grid[r][c]});
                }
            }
        }
        return ans;
    }
}