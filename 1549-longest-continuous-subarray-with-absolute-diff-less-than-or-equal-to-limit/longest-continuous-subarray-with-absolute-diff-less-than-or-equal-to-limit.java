class Solution {
    public int longestSubarray(int[] nums, int limit) {
		int n = nums.length;
		int i = 0, j = 0, maxLen = 0;
		TreeSet<Integer> qMin = new TreeSet<>((i1, j1)->nums[i1]==nums[j1]?i1-j1:nums[i1] - nums[j1]);
		TreeSet<Integer> qMax = new TreeSet<>((i1, j1)->nums[i1]==nums[j1]?i1-j1:nums[j1] - nums[i1]);
		while (j < n) {
			qMin.add(j);
			qMax.add(j);
			// System.out.print("j "+j+" "+qMin + " " + qMax);
			while (nums[qMax.getFirst()] - nums[qMin.getFirst()] > limit) {
				qMin.remove(i);
				qMax.remove(i);
				i++;
			}
			maxLen = Math.max(maxLen, j - i + 1);
			// System.out.print(" " + qMin + " " + qMax + " " + maxLen);
			// System.out.println();
			j++;
		}
		return maxLen;
	}
}


