class Solution {
    private int f (int a[], int k) {
		int count = 0, odd = 0, n = a.length;
		int i = 0, j = 0;
		while (j < n) {
			if (a[j] % 2 != 0)odd++;

			while (odd > k) {
				if (a[i] % 2 != 0)odd--;
				i++;
			}
			int len = j - i + 1;
			count += len ;
			// System.out.println("i: "+i + " j: " + j + " odd: " + odd + " count: " + count);
			j++;
		}
		return count;
	}
	public int numberOfSubarrays(int[] a, int k) {
		return f(a, k) -f(a, k-1);
	}
}