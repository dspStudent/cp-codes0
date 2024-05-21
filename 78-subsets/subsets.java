class Solution {
    private List<List<Integer>>ans;
    private void f(int i, int a[], ArrayList<Integer>list){
        if(i>=a.length){
            ans.add(list);
            return;
        }
        
        f(i+1, a, new ArrayList<>(list));
        list.add(a[i]);
        f(i+1, a, new ArrayList<>(list));
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        f(0, nums, new ArrayList<>());
        return ans;
    }
}