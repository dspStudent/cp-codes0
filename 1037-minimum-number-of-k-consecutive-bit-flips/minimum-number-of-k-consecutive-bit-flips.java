class Solution {
    public int minKBitFlips(int[] a, int k) {
		int n = a.length;
		int ans=0, times=0;
		boolean isFilped[]=new boolean[n];
		for(int i=0;i<n;i++){
			if(i+1<=k){
				if(a[i]%2==times%2){
                    if(n-i+1<=k)return -1;
					times++;
					isFilped[i]=true;
				}
				continue;
			}
			if(isFilped[i-k])times--;
			if(a[i]%2==times%2){
				if(n-i+1<=k)return -1;
				isFilped[i]=true;
				times++;
			}
		}
		for(boolean flips:isFilped)if(flips)ans++;
		return ans;
	}
}


