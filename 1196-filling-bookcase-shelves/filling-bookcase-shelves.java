class Solution {
    int dp[][];
	public int f(int i, int h, int k, int a[][], int w) {
		if (i >= a.length)return h;
		if(dp[i][k]!=-1)return dp[i][k];
		int ans = h+ f(i + 1, a[i][1], w-a[i][0], a, w);

		if (k - a[i][0] >= 0) {
			ans = Math.min(ans, f(i + 1, Math.max(h, a[i][1]), k - a[i][0], a, w));
		}

		return dp[i][k]=ans;
	}

	public int minHeightShelves(int[][] a, int k) {
		int n=a.length;
		
		dp=new int[n][k+1];
		for(int j[]:dp){
			Arrays.fill(j, -1);
		}
		return f(0, 0, k, a, k);
	}
}