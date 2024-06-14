class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int uTrack=0, count=0;
        for(int i:nums){
            uTrack=Math.max(uTrack, i);
            count+=uTrack-i;
            uTrack++;
        }
        return count;
    }
}

// 1 1 2 2 3 7

// numsTracker=3
// minIncrement=1

