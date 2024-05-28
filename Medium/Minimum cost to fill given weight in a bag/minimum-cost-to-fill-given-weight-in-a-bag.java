//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    private static int dp[][];
    private static int f(int i, int a[], int w){
        if(w==0)return 0;
        if(i<0)return (int)1e7;
        if(w<0)return (int)1e7;
        if(dp[i][w]!=-1)return dp[i][w];
        int notTake=f(i-1, a, w);
        int take=(int)(1e7);
        if(w-(i+1) >= 0 && a[i]!=-1){
            take= a[i]+Math.min(f(i, a, w-i-1) , f(i-1, a, w-i-1)) ;
        }
        return dp[i][w]=Math.min(take, notTake);
    }
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        dp=new int [n][w+1];
        for(int i[]:dp)Arrays.fill(i, -1);
        return f(n-1, cost, w);
    }
}
