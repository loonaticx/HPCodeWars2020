import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob14 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean sucess = false;
        for(start = start;start<end;start++)
        {
            if(hasAltSum(start))
            {
                System.out.print(start+ " ");
                sucess = true;
            }
        }
        System.out.print(sucess?"":"No Numbers found with Equal Sum in the given range!!");
    }
    public static boolean hasAltSum(int a)
    {
        int even=0,odd=0;
        String as = String.valueOf(a);
        char[] chars = as.toCharArray();
        for(int i = chars.length-1;i>=0;i--)
        {
            if((chars.length-1-i)%2 == 0)
            {
                even+=chars[i]-48;
            }
            else
            {
                odd+=chars[i]-48;
            }
        }
        if(even==odd)
        {
            return true;
        }
        return false;
    }
}
