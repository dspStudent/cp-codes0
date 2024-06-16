class Solution {
    public int minPatches(int[] nums, int n) {
        long maxNum=0, i=0, count=0;
        while(maxNum<n){
            if(i<nums.length && maxNum+1>=nums[(int)i]){
                maxNum+=nums[(int)i];
                i++;
            }
            else {
                count++;
                maxNum+=(maxNum+1);
            }
        }
        return (int)count;
    }
}