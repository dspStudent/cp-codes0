class Solution {
    public double averageWaitingTime(int[][] a) {
    	int n=a.length;
    	long waitSum=0, makingTime=0;
    	for(int i=0;i<n;i++){
    		int startTime=a[i][0];
    		makingTime=Math.max(makingTime, startTime);
    		int makeTime=a[i][1];
    		makingTime+=makeTime;
    		waitSum+=makingTime-startTime;
    	}
    	return (double)waitSum/(double)n;
    }
}