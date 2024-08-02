//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int dp[][];
	public int f(int i, int j, String s1, String s2) {

		// op.append(i + " " + j + " " + s1 + " " + s2).append("\n");


		if (i < 0 && j < 0)return 0;
		if (i < 0) {
			return j + 1;
		}
		if (j < 0) {
			return i + 1;
		}
		if(dp[i][j]!=-1)return dp[i][j];
		if (s1.charAt(i) == s2.charAt(j))return f(i - 1, j - 1, s1, s2);

		int min = Integer.MAX_VALUE;

		// String remove = s1.substring(0, i) + s1.substring(i + 1, s1.length());

		min = Math.min(min, 1 + f(i - 1, j, s1, s2));

		// String insert = s1.substring(0, i + 1) + s2.charAt(j) + s1.substring(i + 1, s1.length());

		min = Math.min(min, 1 + f(i , j - 1, s1, s2));

		// String replace = s1.substring(0, i) + s2.charAt(j) + s1.substring(i + 1, s1.length());
		min = Math.min(min, 1 + f(i - 1, j - 1, s1, s2));

		return dp[i][j]=min;
	}

	public int editDistance(String s1, String s2) {
		// Code here
		dp=new int[s1.length()][s2.length()];
		for(int i[]:dp)Arrays.fill(i, -1);
		return f(s1.length() - 1, s2.length() - 1, s1, s2);
	}


}