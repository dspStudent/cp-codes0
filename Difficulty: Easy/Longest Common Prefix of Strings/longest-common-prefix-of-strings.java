//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String a[]) {
      
        int n=a.length, l=0, ind=0;
        for(int i=0;i<n;i++){
            String s=a[i];
            if(l<s.length()){
                l=s.length();
                ind=i;
            }
        }
        int hash[][]=new int[l][26];
        for(String s:a){
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                hash[i][c-'a']++;
            }
        }
        int max=0;
        A:
        for(int i=0;i<l;i++){
            for(int j=0;j<26;j++){
                if(hash[i][j]==n){
                    max++;
                }
                
            }
            if(max!=i+1){
                break A;
            }
        }
        if(max==0)return "-1";
        return a[ind].substring(0, max);
    }
}