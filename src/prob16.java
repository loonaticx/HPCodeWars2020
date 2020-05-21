import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob16
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        while(sc.hasNextLine())
        {
            double a = sc.nextInt();
            double b = sc.nextInt();
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            double ans = Double.parseDouble(ss[2]);
            Double realAns;
            if(ss[1].equals("POWER"))
            {
                ss[1] = " ^ ";
                realAns = Math.pow(a,b);
            }
            else if(ss[1].equals("MULTIPLY"))
            {
                ss[1] = " * ";
                realAns = a*b;
            }
            else if(ss[1].equals("DIVIDE"))
            {
                ss[1] = " / ";
                realAns = a/b;
            }
            else if(ss[1].equals("ADD"))
            {
                ss[1] = " + ";
                realAns = a+b;
            }
            else
            {
                ss[1] = " - ";
                realAns = a-b;
            }
            realAns = (double)Math.round(realAns*10)/(double)10;
            System.out.println(realAns.equals(ans)?realAns + " is correct for " + a + ss[1] + b: a + ss[1] + b + " = " + realAns + ", not " + ans);
        }
    }
}
