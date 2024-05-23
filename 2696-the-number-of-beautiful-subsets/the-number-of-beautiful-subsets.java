class Solution {
    private int count=0;
    private boolean h(ArrayList<Integer>a, int k){
        Set<Integer>set=new HashSet<>(a);
        for(int i:a){
            if(set.contains(i+k))return false;
        }
        return true;
    }
    private void f(int i, int[]a, ArrayList<Integer>list, int k){
        if(i>=a.length){
            
            if(h(list, k)){count++;}
            return;
        }
        f(i+1, a, new ArrayList<>(list), k);
        list.add(a[i]);
        f(i+1, a, new ArrayList<>(list), k);
    }
    public int beautifulSubsets(int[] nums, int k) {
        f(0, nums, new ArrayList<>(), k);
        return count-1;
    }
}