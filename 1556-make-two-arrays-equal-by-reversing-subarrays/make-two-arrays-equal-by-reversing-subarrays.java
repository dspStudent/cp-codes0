class Solution {
    public boolean canBeEqual(int[] a, int[] b) {
        int n=a.length;
        Arrays.sort(a);Arrays.sort(b);
        for(int i=0;i<n;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }
}