// "static void main" must be defined in a public class.
import java.util.*
public class Pal {
    public static boolean pl(String s,int i,int j)
    {
        if(i>=j)
            return true;
        if(s.charAt(i)==s.charAt(j))
            return true & pl(s,i+1,j-1);
        else
            return false;
    }
    public static void main(String[] args) {
        System.out.println(pl("oppto",0,4));
        
    }
}