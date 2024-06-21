//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String sa[]=str.split(",");
        String s1[]=sa[0].split("/");
        String s2[]=sa[1].split("/");
        double a=Double.parseDouble(s1[0]);
        double b=Double.parseDouble(s1[1]);
        double c=Double.parseDouble(s2[0]);
        double d=Double.parseDouble(s2[1]);
        if(a/b > c/d){
            return (int)a+"/"+(int)b+"";
        }
        else if(a/b == c/d)return "equal";
        return (int)c+"/"+(int)d+"";
    }
}
