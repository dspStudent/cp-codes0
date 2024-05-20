class Solution {
    private int ans=0;
    public void f(int i, int []a, int xor){
       //0, 1, 3, 
        if(i>=a.length){ ans+=xor;
            return;}
        f(i+1, a, xor^a[i]);
        f(i+1, a, xor);
    }
    public int subsetXORSum(int[] nums) {
        f(0, nums, 0);return ans;
    }
}

//         0
//      0^1   0
// 0^1^3  0^1  