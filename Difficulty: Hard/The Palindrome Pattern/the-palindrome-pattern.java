//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        
        // Code here
        int n=arr.length, m=arr[0].length;
        int left=0, right=m-1, it=0;
        while(it<n){
            int l=left, r=right;
            while(l<r && arr[it][l]==arr[it][r]){
                l++;
                r--;
            }
            if(l>=r)return it+" R";
            it++;
        }
        left=0; right=n-1; it=0;
        while(it<m){
            int l=left, r=right;
            while(l<r && arr[l][it]==arr[r][it]){
                l++;
                r--;
            }
            if(l>=r)return it+" C";
            it++;
        }
        return "-1";
    }
}
