class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        int c=0;int dif=(int)1e9;
        for(int i:nums){
            if((i^k)>i){
                sum+=i^k;
                c++;
                dif=Math.min(dif, (i^k)-i);
            }
            else{
                sum+=i;
                dif=Math.min(dif, i-(i^k));
            }
        }
        if(c%2==0)return sum;
        return sum-dif;
    }
}