class Solution {
    int dp[];
    private int f(int i, String s){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int min=Integer.MAX_VALUE;
        int hash[]=new int[26];
        for(int k=i;k>=0;k--){
            char c=s.charAt(k);
            hash[c-'a']++;
            int minf=Integer.MAX_VALUE, maxf=-1;
            for(int it:hash)if(it!=0){
                minf=Math.min(minf, it);
                maxf=Math.max(maxf, it);
            }
            if(minf==maxf){
            min=Math.min(min, 1+f(k-1, s));}
            
        }
        dp[i]=min;
        return min;
    }
    public int minimumSubstringsInPartition(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp , -1);
       return f(s.length()-1, s);
    }
}