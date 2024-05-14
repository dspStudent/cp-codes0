//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



// class Solution {
//     public static int MinimumEffort(int rows, int columns, int[][] heights) {
//         // code here
//     }
// }

class Solution {
    public static int MinimumEffort(int rows, int columns,int[][] hi) {
        int m=hi.length, n=hi[0].length;
        int [][]di=new int[m][n];
        for(int i[]:di)Arrays.fill(i, 10000001);
        di[0][0]=0;
        PriorityQueue<int[]>q=new PriorityQueue<>((i, j)->  Integer.compare(i[2],j[2]));
        q.add(new int[]{0, 0, 0});
        while(!q.isEmpty()){
            int x[]=q.poll();
            // System.out.println(Arrays.toString(x));
            int r=x[0], c=x[1], dis=x[2];
            if(r==m-1 && c==n-1)return dis;
            int drow[]={1, -1, 0, 0};
            int dcol[]={0, 0, -1, 1};
            for(int i=0;i<4;i++){
                int nr=r+drow[i], nc=c+dcol[i];

                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    if(di[nr][nc]>dis){
                    di[nr][nc]=Math.abs(hi[r][c]-hi[nr][nc]);
                    int temp=di[nr][nc];
                    if(temp<dis)temp=dis;
                    di[nr][nc]=temp;
                    q.add(new int[]{nr, nc, temp});
                    }
                    // else di[nr][nc]=dis;
                    // System.out.println(nr+" "+nc);
                    
                }
            }
        }
        return di[m-1][n-1];
        
    }
}