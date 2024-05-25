//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends



class Solution {
    long max_Books(int arr[], int n, int k) {
        long max=0;
        // Your code here
        int i=0;
        while(i<n){
            if(arr[i]<=k){
                int j=i;
                long sum=0;
                while(j<n&&arr[j]<=k){
                    sum+=arr[j];
                    j++;
                }
                i=j;
                max=Math.max(max, sum);
            }
            else i++;
        }
        return max;
    }
}