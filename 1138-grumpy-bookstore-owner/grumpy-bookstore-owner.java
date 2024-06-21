class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=grumpy.length;
        int all=0;
        for(int i=0;i<n;i++)all+=(1-grumpy[i])*customers[i];
        int winSum=0, winZeroSum=0, ans=0;
        for(int i=0;i<n;i++){
            winSum+=customers[i];
            winZeroSum+=(1-grumpy[i])*customers[i];
            if(i+1>=minutes){
                ans=Math.max(ans, all-winZeroSum+winSum);
                winSum-=customers[i+1 - minutes];
                winZeroSum-=(1-grumpy[i+1 - minutes])*customers[i+1 - minutes];
            }
        }
        return ans;
    }
}