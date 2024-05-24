//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findWays(int num[], int tar){
        int n = num.length;
        int []prev=new int[tar+1];
        Arrays.fill(prev, 0);

        if (num[0] == 0)
            prev[0] = 2; // 2 cases -pick and not pick
        else
            prev[0] = 1; // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar)
            prev[num[0]] = 1; // 1 case -pick

        for (int ind = 1; ind < n; ind++) {
            int []cur=new int[tar+1];
            Arrays.fill(cur, 0);
            for (int target = 0; target <= tar; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (num[ind] <= target) 
                    taken = prev[target - num[ind]];

                cur[target] = (notTaken + taken) % 1000000007;
            }
            prev = cur;
        }
        return prev[tar];
    }
    
    
    public int countPartitions(int n, int d, int arr[]){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(sum-d<0 || (sum-d)%2==1){
            return 0;
        }
        return findWays(arr, (sum-d)/2);
    }
}