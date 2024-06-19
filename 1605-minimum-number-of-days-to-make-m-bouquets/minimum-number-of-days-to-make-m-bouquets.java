class Solution {
    public boolean f(int mid,int[]a,int b,int fl){
        int count=0,nf=0;
        for(int i:a)
        {
            if(i<=mid)count++;
            else{ nf+=count/fl;
            count=0;}
        }
        nf+=count/fl;
        // System.out.println(" count "+ nf);
        return nf>=b;
    }
    public int minDays(int[] a, int m, int k) {
        long val = (long) m * k;
        
        if (val > a.length) return -1;
        int start=1,end=Integer.MAX_VALUE;
        Solution s=new Solution();
        while(start<end)
        {
            int mid=start+(end-start)/2;
            // System.out.println(" start: "+start+" end "+end+" mid "+mid);
            if(s.f(mid,a,m,k))end=mid;
            else start=mid+1;
        }
        if(end==Integer.MAX_VALUE)
        return -1;
        return end;
    }
}