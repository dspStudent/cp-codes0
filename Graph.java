import java.util.*;
public class Main {
    static HashMap<Integer,ArrayList<Integer>>a=new HashMap<>();
    static int vis[]=new int[5];
    public static void dfs(int node)
    {
        if(vis[node]==1)
            return;
        System.out.println(node);
       if(vis[node]!=1)
        {
            vis[node]=1;
            for(int i:a.get(node))
            {
                dfs(i);
            }
        }
    }
    // public static void dfs()
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Scanner sc=new Scanner(System.in);
        int ver=sc.nextInt();
        for(int i=0;i<ver;i++)
        {
            a.put(i,new ArrayList<Integer>());
            vis[i]=0;
        }
        for(int i=0;i<ver;i++)
        {
            
            int x=sc.nextInt();
            int y=sc.nextInt();
            a.get(x).add(y);
            a.get(y).add(x);
        }
        for(int i:a.keySet())
        {
            System.out.print("ver: "+i+" : ");
            for(int j:a.get(i))
            {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
        dfs(0);
        
    }
}