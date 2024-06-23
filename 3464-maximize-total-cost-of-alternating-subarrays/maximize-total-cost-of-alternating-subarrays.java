class Solution {
    private long dp[][][];
    private long f(int i, boolean start, int sign, int a[]) {

        if(i==a.length)return 0;
        int j=start?1:0, k=sign==-1?1:0;
        if(dp[i][j][k]!=-1)return dp[i][j][k];
        // System.out.println(dp[i][j][k]);

        return dp[i][j][k]=Math.max(sign*a[i]+f(i+1, false, -1*sign, a), 
            sign*a[i]+f(i+1, true, 1, a));
    }

    public long maximumTotalCost(int[] nums) {
        dp = new long[nums.length][2][2];
        for(long i[][]:dp)
            for(long j[]:i)
        Arrays.fill(j, -1);
        return f(0, true, 1, nums);
    }
}

