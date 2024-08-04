class Solution {
    class Pair{
        int el, ind;
        Pair(int el, int ind){
            this.el=el;
            this.ind=ind;
        }
        public String toString(){
            return " <"+this.el+" "+this.ind+"> ";
        }
    }
    int mod=(int)(1e9 + 7);
    public int rangeSum(int[] a, int n, int left, int right) {
        PriorityQueue<Pair>q=new PriorityQueue<>((i, j)->i.el-j.el);
        for(int i=0;i<n;i++)q.add(new Pair(a[i], i));
        int it=1, sum=0;
        // System.out.println(mod+" "+Arrays.toString(a));
        while(!q.isEmpty()){
            // System.out.println(q);
            Pair poll=q.poll();
            int pref=poll.el, index=poll.ind;
            if(it>right)return sum;
            if(it>=left && it<=right){
                sum=(sum+pref)%mod;
            }
            if(index+1<n){
                pref=(pref+a[index+1]);
                q.add(new Pair(pref, index+1));
            }   
            it++;
        }
        return sum;
    }
}