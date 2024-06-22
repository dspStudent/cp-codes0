//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        int n=sentence.length();
        long num=-1, ans=-1;
        int i=0;
        while(i<n){
            char c=sentence.charAt(i);
            if(c>='0' && c<='8'){
                num=num==-1?0:num;
                num=num*10+(c-'0');
            }
            else if(c=='9'){
                num=-1;
                while( i< n &&sentence.charAt(i)>='0' && sentence.charAt(i)<='9'){
                    i++;
                }
                continue;
            }
            else{
                ans=Math.max(ans, num);
                num=-1;
            }
            i++;
        }
        ans=Math.max(ans, num);
        return ans;
    }
}