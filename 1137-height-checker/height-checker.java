class Solution {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int ex[]=new int[n];
        for(int i=0;i<n;i++)ex[i]=heights[i];
        Arrays.sort(ex);
        int count=0;
        for(int i=0;i<n;i++){
            if(ex[i]!=heights[i])count++;
        }
        return count;
    }
}