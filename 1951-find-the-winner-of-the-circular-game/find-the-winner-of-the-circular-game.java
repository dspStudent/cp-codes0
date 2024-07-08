class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer>a=new ArrayList<>();
        for(int i=1;i<=n;i++)a.add(i);
        int loc=k-1;
        while(a.size()!=1){
            loc=loc%a.size();
            a.remove(loc);
            loc+=k-1;
        }
        return a.get(0);
    }
}
