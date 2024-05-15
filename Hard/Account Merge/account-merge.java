//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

// class Solution {
//   static List<List<String>> accountsMerge(List<List<String>> accounts) {
//     // code here
    
//   }
// }

class DisjointSetUnion {
    int djs[];
    int rank[];
    int size[];
    int max;
    DisjointSetUnion(int max){
        this.max=max;
        djs=new int[max];
        rank=new int[max];
        size=new int[max];
        Arrays.fill(rank, 0);
        Arrays.fill(size, 1);
        for(int i=0;i<max;i++){
            djs[i]=i;
        }
    }
    public int supParent(int x){
        if(x==djs[x])return x;
        return djs[x]=supParent(djs[x]);
    }
    private boolean isComponet(int x, int y){
        return djs[x]==djs[y];
    }
    public void addUniByRank(int x, int y){
        int parx=supParent(x);
        int pary=supParent(y);
        if(parx==pary)return;
        if(rank[parx]==rank[pary]){
            djs[pary]=djs[parx];
            rank[parx]++;
        }
        else if(rank[parx]<rank[pary]){
            djs[parx]=djs[pary];
        }
        else{
            djs[pary]=djs[parx];
        }
    }
    public void addUniBySize(int x, int y){
        int parx=supParent(x);
        int pary=supParent(y);
        if(parx==pary)return;
        if(size[parx] > size[pary]){
            djs[pary]=parx;
            size[parx]+=size[pary];
        }
        else{
            djs[parx]=pary;
            size[pary]+=size[parx];
        }
    }
}
class Solution {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSetUnion ds=new DisjointSetUnion(accounts.size());
        TreeMap<String, Integer>map=new TreeMap<>();
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s=accounts.get(i).get(j);
                if(map.containsKey(s)){
                    ds.addUniByRank(map.get(s), i);
                    continue;
                }
                map.put(s, i);
            }
        }
        List<List<String>>ans=new ArrayList<>();
        TreeMap<Integer, ArrayList<String>>map1=new TreeMap<>();
        for(String s:map.keySet()){
            int i=ds.supParent(map.get(s));
            if(map1.containsKey(i))map1.get(i).add(s);
            else {map1.put(i, new ArrayList<>());map1.get(i).add(s);}
        }
        
        for(int i:map1.keySet()){
            ArrayList<String>s=new ArrayList<>();
            s.add(accounts.get(i).get(0));
            s.addAll(map1.get(i));
            ans.add(new ArrayList<>(s));
        }

        return ans;
    }
}
