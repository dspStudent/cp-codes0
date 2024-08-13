class Solution {
    public void h(List<List<Integer>>ans, List<Integer>a, int c[], int k, int sum, int i){
        if(sum>=k){
            if(sum==k){
                ans.add(new ArrayList<>(a));
            }
            return;
        }
        
        for(int j=i;j<c.length;j++)
        {
                if(j>i && c[j]==c[j-1])continue;
                if(c[j]>k)return;
                a.add(c[j]);
                h(ans, a, c, k, sum+c[j], j+1);
                a.remove(a.size()-1);
            
        }
    }
    public List<List<Integer>> combinationSum2(int[] c, int k) {
        Arrays.sort(c);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        h(ans, a, c, k, 0, 0);
        
        return ans;
    }
}