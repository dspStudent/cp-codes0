class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if((grid[i][0]==0)){
                for(int j=0;j<n;j++)grid[i][j]^=1;
            }
        }
        for(int i=0;i<n;i++){
            int o=0,z=0;
            for(int j=m-1;j>=0;j--){
                if(grid[j][i]==1)
                o++;
                else z++;
            }
            if(o<z){
                for(int j=0;j<m;j++)grid[j][i]^=1;
            }
        }
        int ans1=0;
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1)
                ans1+=(int)Math.pow(2, (n-1)-j);
            }
        }
        return ans1;
    }
}

