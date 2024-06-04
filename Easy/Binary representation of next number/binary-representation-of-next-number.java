//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        int i=0;
        while(i<s.length() && s.charAt(i)=='0')i++;
        
        s=s.substring(i);
        // code here.
        String ans="";
        i=s.length()-1;
        while(i>=0 && s.charAt(i)=='1'){
            ans="0"+ans;
            i--;
        }
        if(i>=0)
        ans= s.substring(0, i)+"1"+ans;
        else
        ans= "1"+ans;
        
        
       return ans;
    }
}