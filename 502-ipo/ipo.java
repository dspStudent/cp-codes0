class Solution {
    private static class Projects{
        int cap;
        int prof;
        Projects(int cap, int prof){
            this.cap=cap;
            this.prof=prof;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        Projects []p=new Projects[n];
        for(int i=0;i<n;i++)p[i]=new Projects(capital[i], profits[i]);
        Arrays.sort(p, (i, j)->i.cap-j.cap);
        PriorityQueue<Projects>q=new PriorityQueue<>((i, j)->j.prof-i.prof);
        int ind=0;
        while(k-->0){
            // System.out.println(w);
            while(ind<n && w>=p[ind].cap){
                q.add(p[ind++]);
                // System.out.println(w);
            }

            if(q.isEmpty())break;

            
            w+=q.poll().prof;
            // System.out.println(w);
        }
        return w;
    }
}