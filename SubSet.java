import java.util.*
public class SubSet {
    static int res=1;
    public static int p(int a, int b)
    {
        
        if(b==0)
            return 1;
        if(b%2==0)
        {
            int temp=p(a,b/2);
            return temp*temp;
        }
        else 
        {
            int temp=p(a,b/2);
            return a*temp*temp;
        }
        
        
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Scanner sc =new Scanner(System.in);
        // int a=sc.nextInt();
        // int b=sc.nextInt();
        // p(a,b);
        System.out.print("type p: ");
        int p=sc.nextInt();
        // String s[]=new String[26];
        String[] s = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        // System.out.println(p(2,3));
        for(int i=1;i<p(2,p);i++)
        {
            int b=i;int count=p;String str="";
            while(b!=0)
            {
                --count;
                if((b&1)!=0)
                    str=str+s[count];
                b>>=1;
            }
            System.out.println(str);
            
        }
        
        
    }
}