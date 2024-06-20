import java.util.*;

class Solution {
    public static boolean h(int[] a, int m, int an) {
        int count = 1;
        int prevPos = a[0];
        
        for (int i = 1; i < a.length; i++) {
            if (a[i] - prevPos >= an) {
                count++;
                prevPos = a[i];
            }
        }
        
        return count >= m;
    }

    public int maxDistance(int[] a, int m) {
        Arrays.sort(a);
        int l = 1, r = a[a.length - 1] - a[0];
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (h(a, m, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
