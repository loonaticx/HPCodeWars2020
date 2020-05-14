import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob12 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        while(sc.hasNextLine())
        {
            String g = sc.nextLine();
            String[] gs = g.split(" ");
            if(gs.length == 1)
            {
                int y = Integer.parseInt(gs[0]);
                y*=36;
                System.out.printf("%.2f\n",y*2.54);
            }
            else if(gs.length == 2)
            {
                int y = Integer.parseInt(gs[0]);
                int f = Integer.parseInt(gs[1]);
                f+=y*3;
                f*=12;
                System.out.printf("%.2f\n",f*2.54);
            }
            else
            {
                int y = Integer.parseInt(gs[0]);
                int f = Integer.parseInt(gs[1]);
                int i = Integer.parseInt(gs[2]);
                f+= y*3;
                i+= f*12;
                System.out.printf("%.2f\n",i*2.54);
            }
        }
    }
}
