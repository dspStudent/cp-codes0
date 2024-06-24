class Solution {
    public int minOperations(int[] a) {
        int n=a.length;
        int times=0;
        for(int i=0;i<n;i++){
            if(times%2==a[i]){
                times++;
            }
        }
        return times;
    }
}