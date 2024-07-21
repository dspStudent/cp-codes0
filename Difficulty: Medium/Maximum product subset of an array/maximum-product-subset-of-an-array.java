//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int mod=(int)1e9+7;
    public long findMaxProduct(List<Integer> a) {
        int n=a.size();
        if(n==2){
            return (long)Math.max(a.get(0), Math.max(a.get(1)*a.get(0), a.get(1)));
        }
        if(n==1)return (long)a.get(0);
        Collections.sort(a);
        long ans=1L;
        int el=a.get(0), i=0, nC=0, z=0, po=n;
        while(i<n){
            if(a.get(i)<0)nC++;
            if(a.get(i)==0)z++;
            if(a.get(i)>0){po=i;break;}
            i++;
        }
        i=0;
        nC=nC%2==0?nC:nC-1;
        while(i<nC){
            ans=(long)(((ans%mod)*a.get(i))%mod);
            i++;
        }
        i=po;
        while(i<n){
            ans=(long)(((ans%mod)*a.get(i))%mod);
            i++;
        }
        return ans;
    }
}