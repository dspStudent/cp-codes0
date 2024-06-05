//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        long aSum=Arrays.stream(a).sum();
        long bSum=Arrays.stream(b).sum();
        
        // long aSum=0, bSum=0;
        // for(long i:a)aSum+=i;
        // for(long i:b)bSum+=i;
        if((aSum+bSum)%2!=0)return -1;
        long dif=(aSum-bSum)/2;
        Arrays.sort(a);Arrays.sort(b);
        int i=0, j=0;
        while(i<a.length && j<b.length){
            if(a[i]-b[j]==dif)return 1;
            if(a[i]-b[j]>dif){
                j++;
            }
            else {
                i++;
            }
        }
        return -1;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends