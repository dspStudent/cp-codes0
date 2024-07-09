//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int a[], int k){
    	Arrays.sort(a);
    	int n=a.length, ans=0, min=Integer.MAX_VALUE;
    	for(int i=0;i<n;i++){
    		int sum=k-a[i];
    		int start=i+1, end=n-1;
    		while(start<end){
    			int summ=a[start]+a[end];
    			if(min==Math.abs(summ-sum)){
    				ans=Math.max(summ+a[i], ans);
    			}
    			if(min> Math.abs(summ-sum)){
    				min=Math.abs(summ-sum);
    				ans=summ+a[i];
    			}
    			if(summ==sum)return k;
    			if(summ>sum){
    				end--;
    			}
    			else{
    				start++;
    			}
    		}
    	}
    	return ans;
    }
}
