class Solution {
    long dp[][][];
    int mod=(int)1e9 +7;
    int gcd(int a, int b){
        if(b>a)return gcd(b, a);
        if(b==0)return a;
        if(b==1 || a==1)return 1;
        return gcd(a%b, b);
    }
    long f(int []nums, int i, int gcd1, int gcd2){
        
        if(i==nums.length){
            if(gcd1==gcd2){
                return 1;
            }
            return 0;
        }
        if(dp[i][gcd1][gcd2]!=-1)return dp[i][gcd1][gcd2];
        // int nntake+=f(nums, i+1, gcd1, gcd2);

        // int n1take+=f(nums, i+1, gcd(gcd1, nums[i]), gcd2);

        // int n2take+=f(nums, i+1, gcd1, gcd(gcd2, nums[i]));

        // return nntake+n1take+n2take;

        return dp[i][gcd1][gcd2]=(

            ((f(nums, i+1, gcd1, gcd2)+mod)%mod+ 
            (f(nums, i+1, gcd(gcd1, nums[i])%mod, gcd2)+mod)%mod+
            (f(nums, i+1, gcd1, gcd(gcd2, nums[i]))+mod)%mod) 

         )%mod;
    }
    public int subsequencePairCount(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        dp=new long[nums.length][max+1][max+1];
        for(long i[][]:dp){
            for(long j[]:i)Arrays.fill(j, -1);
        }
        return (int)f(nums, 0, 0, 0)-1;
    }
}