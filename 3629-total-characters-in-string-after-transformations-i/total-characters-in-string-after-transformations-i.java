class Solution {
    int mod=(int)1e9 +7;
    public int lengthAfterTransformations(String s, int t) {
        int ans=0;
        int hash[]=new int[26];
        for(char c:s.toCharArray())hash[c-'a']++;

        for(int i=0;i<t;i++){
            int dp[]=new int[26];
            for(int j=0;j<26;j++){
                if(j==25){
                    dp[0]=(dp[0]+hash[j])%mod;
                    dp[1]=(dp[1]+hash[j])%mod;
                }
                else{
                    dp[j+1]=(dp[j+1]+hash[j])%mod;
                }   
            }
            hash=dp;
        }
        for(int i:hash)ans=(ans+i)%mod;
        return ans;
    }
}