class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i[]:grid)System.out.println(Arrays.toString(i));System.out.println("--");
        // int rowMax=(int)Math.pow(2, m)-1;
        // int colMax=(int)Math.pow(2, n)-1;
        for(int i=0;i<m;i++){
            int not=0,tot=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1)
                not+=(int)Math.pow(2, (n-1)-j);
                else tot+=(int)Math.pow(2, n-1-j);
            }
            if(not<tot){
                for(int j=0;j<n;j++)grid[i][j]^=1;
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1)
                ans+=(int)Math.pow(2, (n-1)-j);
            }
        }
        for(int i[]:grid)System.out.println(Arrays.toString(i));
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
        System.out.println("--");
        for(int i[]:grid)System.out.println(Arrays.toString(i));
        if(ans1>ans)return ans1;
        return ans;
    }
}

