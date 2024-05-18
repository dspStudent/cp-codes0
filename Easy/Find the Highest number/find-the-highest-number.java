//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findPeakElement(List<Integer> a) {
         a.add(Integer.MAX_VALUE);
         int start=1, end=a.size()-2;
         while(start<=end){
             int mid=start+(end-start)/2;
             if(a.get(mid)>a.get(mid-1) && a.get(mid)>a.get(mid+1)){
                 return a.get(mid);
             }
             else if(a.get(mid)>a.get(mid-1) && a.get(mid)<a.get(mid+1) ){
                 start=mid+1;
             }
             else end=mid-1;
         }
         return a.get(end);
    }
}