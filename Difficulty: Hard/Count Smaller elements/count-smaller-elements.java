//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    Map<A, Integer>map;

    class A{
    	int el;
    	int ind;
    	A(int el, int ind){
    		this.el=el;
    		this.ind=ind;
    	}
    	public  String toString(){
    		return this.el+" "+this.ind;
    	}
    }


    int[] constructLowerArray(int[] arr) {
        map=new HashMap<>();

        int n=arr.length;
        // int arr[]=new int[n];
        A a[]=new A[n];
        for(int i=0;i<n;i++){
        	a[i]=new A(arr[i], i);
        }
        mergeSort(a, 0, n-1);
        int ans[]=new int[n];
        // op.append(map).append("\n");
        for(A i:map.keySet()){
        	ans[i.ind]=map.getOrDefault(i, 0);
        }
        // op.append(map).append("\n");
        return ans;
    }



    public void mergeSort(A a[], int start, int end){
    	if(start>=end)return;
    	int mid=start+(end -start)/2;
    	mergeSort(a, start, mid);
    	mergeSort(a, mid+1, end);
    	a=run(a, start, mid, end);
        return ;
    }

    public A[] run(A a[], int start , int mid, int end){
    	int l=start, r=end;
    	A b[]=new A[end-start+1];
    	int i=start, j=mid+1, k=0;
    	while(i<=mid && j<=end){
    		if(a[i].el>a[j].el){
    			map.put(a[i], map.getOrDefault(a[i], 0)+end-j+1);
    			// op.append(map+" "+start+" "+end).append("\n");
    			b[k]=a[i];
    			i++;
    		}
    		else{
    			// map.put(a[j], map.getOrDefault(a[j], 0)+mid-i+1);
    			b[k]=a[j];
    			j++;
    		}
    		k++;
    	}
    	while(i<=mid){
    		b[k++]=a[i++];
    	}
    	while(j<=end){
    		b[k++]=a[j++];
    	}
    	for(int s=start, it=0;s<=end;s++, it++){
    		// b[it]=a[s];
    		a[s]=b[it];
    	}
        return a;
    }


}