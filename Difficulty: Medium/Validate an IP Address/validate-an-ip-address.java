//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    boolean isDigit(String num){
        try{
            Integer.parseInt(num);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    public boolean isValid(String str) {
        // Write your code here
        String num="";
        int count=0;
        for(char c:str.toCharArray()){
            if(c=='.'){
                if(count>3)return false;
                if(num.equals(""))return false;
                if(Integer.parseInt(num)>255 || Integer.parseInt(num)<0)return false;
                num="";
                count++;
                continue;
            }
            if(isDigit(c+"")){
                num+=c;
            }
            else return false;
        }
        if(Integer.parseInt(num)>255 || Integer.parseInt(num)<0)return false;
        return true;
    }
}