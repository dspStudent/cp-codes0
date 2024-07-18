//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int[] leftMin(int a[]) {
		int n = a.length;
		int leftMin[] = new int[n];
		leftMin[0] = -1;
		int i = 0;
		Stack<Integer>st = new Stack<>();
		st.push(0);
		while (i < n) {
			while (!st.isEmpty() && a[st.peek()] >= a[i])st.pop();
			if (st.isEmpty())leftMin[i] = -1;
			else leftMin[i] = st.peek();
			st.push(i);
			i++;
		}
		return leftMin;
	}
	public int[] rightMin(int a[]) {
		int n = a.length;
		int rightMin[] = new int[n];
		rightMin[n - 1] = -1;
		int i = n - 2;
		Stack<Integer>st = new Stack<>();
		st.push(n - 1);
		while (i >= 0) {
			while (!st.isEmpty() && a[st.peek()] >= a[i])st.pop();
			if (st.isEmpty())rightMin[i] = -1;
			else rightMin[i] = st.peek();
			st.push(i);
			i--;
		}
		return rightMin;
	}
	public int[] leftMax(int a[]) {
		int n = a.length;
		int leftMax[] = new int[n];
		leftMax[0] = -1;
		int i = 0;
		Stack<Integer>st = new Stack<>();
		st.push(0);
		while (i < n) {
			while (!st.isEmpty() && a[st.peek()] <= a[i])st.pop();
			if (st.isEmpty())leftMax[i] = -1;
			else leftMax[i] = st.peek();
			st.push(i);
			i++;
		}
		return leftMax;
	}
	public int[] rightMax(int a[]) {
		int n = a.length;
		int rightMax[] = new int[n];
		rightMax[n - 1] = -1;
		int i = n - 2;
		Stack<Integer>st = new Stack<>();
		st.push(n - 1);
		while (i >= 0) {
			while (!st.isEmpty() && a[st.peek()] <= a[i])st.pop();
			if (st.isEmpty())rightMax[i] = -1;
			else rightMax[i] = st.peek();
			st.push(i);
			i--;
		}
		return rightMax;
	}










	public int alternatingMaxLength1(int a[]) {
		int rightMi[] = rightMin(a);
		int rightMa[] = rightMax(a);
		// for (int i = 0; i < a.length; i++)al[i] = a[i];
		// System.out.println(Arrays.toString(rightMa));
		// System.out.println(Arrays.toString(rightMi));
		
		int n = a.length, ans = 0;
		for (int i = 0; i < n; i++) {
			int max = max(a, i, rightMi, rightMa);
			int min = min(a, i, rightMi, rightMa);
			// op.append(max + " " + min).append("\n");
			ans = Math.max(ans, Math.max(max, min));
		}
		return ans;
	}




	public int max(int a[], int index, int[]rightMi, int []rightMa) {

		int count = 0;
		int i = index, n = a.length;
		int rightSmall = -1, rightBig = -1;
		boolean turn = true;
		while (i < n) {
			count++;
			if (turn) {
				int rm = rightMa[i];
				if (rm == -1|| rm==i)return count;
				i = rm;
				
				turn = false;
			} else {
				int rm = rightMi[i];
				if (rm == -1|| rm==i)return count;
				i = rm;
				
				turn = true;
			}
		}
		return count++;
	}

	public int min(int a[], int index, int[]rightMi, int []rightMa) {

		int count = 0;
		int i = index, n = a.length;
		
		boolean turn = false;
		while (i < n) {
			count++;
			if (turn) {
				int rm = rightMa[i];
				
				if (rm == -1 || rm==i)return count;
				i = rm;
				
				turn = false;
			} else {
				int rm = rightMi[i];
				// op.append(rm+" "+i+" "+index).append("\n");
				if (rm == -1 || rm==i)return count;
				i = rm;
				
				turn = true;
			}
		}
		return count++;
	}
	public int alternatingMaxLength(int a[]){
		int up=1, down=1, n=a.length;
		for(int i=1;i<n;i++){
			if(a[i-1]>a[i]){
				down=up+1;
			}
			if(a[i-1]<a[i]){
				up=down+1;
			}
		}
		return Math.max(up, down);
	}
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends