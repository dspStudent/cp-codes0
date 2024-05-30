//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    private static int dp[][];
    private static final int mod=(int)(1e9)+7;
    private static int  f(int i, int j, String s1, String s2){
        if(j<0 && i<0 || j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=(f(i-1, j-1, s1, s2) + f(i-1, j, s1, s2))%mod; 
        }
        return dp[i][j]=f(i-1, j, s1, s2);
    }
    public static int countWays(String s1, String s2) {
        // code here
        dp=new int[s1.length()][s2.length()];
        for(int i[]:dp)Arrays.fill(i, -1);
        return f(s1.length()-1, s2.length()-1, s1, s2);
    }
}
