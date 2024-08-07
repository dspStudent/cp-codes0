//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Method to find the kth element in two sorted arrays
    int kth(int arr1[], int arr2[], int s1, int e1, int s2, int e2, int k) {
        // Base case: If one array is empty, return kth element from the other array
        if (s1 == e1) return arr2[s2 + k];
        if (s2 == e2) return arr1[s1 + k];

        // Calculate the middle indices of the two arrays
        int m1 = (e1 - s1) / 2;
        int m2 = (e2 - s2) / 2;

        // If the sum of middle indices is less than k
        if (m1 + m2 < k) {
            // Compare the middle elements of the two arrays
            if (arr1[s1 + m1] > arr2[s2 + m2])
                // Recursively search in the second half of the second array
                return kth(arr1, arr2, s1, e1, s2 + m2 + 1, e2, k - m2 - 1);
            else
                // Recursively search in the second half of the first array
                return kth(arr1, arr2, s1 + m1 + 1, e1, s2, e2, k - m1 - 1);
        } else {
            // If the sum of middle indices is greater than or equal to k
            if (arr1[s1 + m1] > arr2[s2 + m2])
                // Recursively search in the first half of the first array
                return kth(arr1, arr2, s1, s1 + m1, s2, e2, k);
            else
                // Recursively search in the first half of the second array
                return kth(arr1, arr2, s1, e1, s2, s2 + m2, k);
        }
    }

    // Method to find the kth element in two sorted arrays
    public long kthElement(int k, int arr1[], int arr2[]) {
        // Call the recursive method to find the kth element
        return kth(arr1, arr2, 0, arr1.length, 0, arr2.length, k - 1);
    }
};