//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
        int charRe=0, charC=0;
        for(char c:str.toCharArray()){
            if(c>='a' && c<='z')charC++;
        }
        
        // if(charC>=26 && k>=25)return true;
        // System.out.println(charC);
        for(char i='a';i<='z';i++){
            if(str.indexOf(i)==-1){
                
                if(k==0)return false;
                if(charC==0)return false;
                k--;    
            }
            if(charC<=0)return false;
            charC--;
        }
        // System.out.println(k+" "+charC);
        return true;
    }
}