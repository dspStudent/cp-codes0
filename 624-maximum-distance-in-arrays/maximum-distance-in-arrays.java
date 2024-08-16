class Solution {
    class Pair{
        int ind;
        int val;
        Pair(int ind, int val){
            this.ind=ind;this.val=val;
        }
        public String toString(){
            return " [ "+this.ind+" "+this.val+" ] ";
        }
    }
    public int maxDistance(List<List<Integer>> a) {
        PriorityQueue<Pair> minHeap=new PriorityQueue<Pair>((i, j)->i.val-j.val);
        PriorityQueue<Pair> maxHeap=new PriorityQueue<Pair>((i, j)->j.val-i.val);
        int n=a.size();
        for(int i=0;i<n;i++){
            int m=a.get(i).size();
            minHeap.add(new Pair(i, a.get(i).get(m-1)));
            maxHeap.add(new Pair(i, a.get(i).get(0)));
            if(minHeap.size()>2)minHeap.poll();
            if(maxHeap.size()>2)maxHeap.poll();
        }
        // System.out.println(minHeap);
        // System.out.println(maxHeap);

        Pair max2=minHeap.poll();
        Pair max1=minHeap.poll();
        Pair min2=maxHeap.poll();
        Pair min1=maxHeap.poll();

        if(min1.ind!=max1.ind)return max1.val-min1.val;
        return Math.max(max2.val-min1.val, max1.val-min2.val);  
    }
}