//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        ArrayList<Integer>a=new ArrayList<>();
        int n=mat.length, m=mat[0].length;
        int ru=0, cu=0, rd=n-1, cd=m-1;
        while(ru<=rd && cu<=cd){
        	int i=cu;
        	while(i<=cd){
        		a.add(mat[ru][i]);//1, 2 // 
        		i++;
        	}
        	ru++;
        	i=ru;
        	while(i<=rd){
        		a.add(mat[i][cd]);// // 
        		i++;
        	}
        	cd--;
        	i=cd;
        	while(i>=cu && ru<=rd){
        		a.add(mat[rd][i]);//
        		i--;
        	}
        	rd--;
        	i=rd;
        	while(i>=ru && cu<=cd){
        		a.add(mat[i][cu]);
        		i--;
        	}
        	cu++;
        }
        return a;
    }

}
