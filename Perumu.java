// "static void main" must be defined in a public class.
import java.util.*;
public class Perumu {
    static int count=0;
    public static void swap(char ca[], int one, int two)
    {
        char temp=ca[two];
        ca[two]=ca[one];
        ca[one]=temp;
    }
   public static void perum(char ca[],int index)
   {
        if(index>=ca.length-1)
        {
            count++;
            System.out.println(String.copyValueOf(ca)+" "+count);
            return;
        }
        for(int i=index;i<ca.length;i++)
        {
            swap(ca,index,i);
            perum(ca, index+1);
            
        }
        return;
   }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);System.out.println("enter input: ")
       String s=sc.nextLine();
       char ca[]=s.toCharArray();
       perum(ca,0);
    }
}