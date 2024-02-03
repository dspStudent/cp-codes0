// "static void main" must be defined in a public class.
public class Main {
    public static class Heap{
        static ArrayList<Integer>a=new ArrayList<>();
        Heap(int n, ArrayList<Integer>a)
        {
            this.a=a;
        }
        public static void hepify(int i)
        {
            
            int leftchild=2*i+1;
            int rightchild=2*i+2;
            int minindex=i;
            if( a.size() > leftchild && a.get(leftchild) < a.get(minindex) )
                minindex=leftchild;
            if( a.size() > rightchild && a.get(rightchild) < a.get(minindex) )
                minindex=rightchild;
            if(minindex!=i)
            {
                swap(minindex, i);
                if( 2*minindex+1<a.size() || 2*minindex+2<a.size() )
                    hepify(minindex);
            }
        }
        public static void build()
        {
            int parchild=((a.size()-1)-1)/2;
            for(int i=parchild;i>=0;i--)
            {
                hepify(i);
            }
        }
        public static void swap(int i, int j) {
            int temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        }
        public static void print()
        {
            for(int i:a)
            {
                System.out.println(i);
            }
        }
        public static void push(int x)
        {
            a.add(x);
            int cur=a.size()-1;
            int par=(cur-1)/2;
            while(a.get(cur)<a.get(par) && cur>0)
            {
                swap(cur,par);
                cur=par;
                par=(cur-1)/2;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer>a=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            a.add(sc.nextInt());
        }
        Heap h=new Heap(n,a);
        h.build();
        h.push(0);
        h.print();
    }
}