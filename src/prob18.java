import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob18
{
    public static void main(String[] args) throws IOException {
        Scanner  sc = new Scanner(new File("input.txt"));
        while(sc.hasNextLine())
        {
            String x = sc.nextLine();
            String[] memes = x.split(":");
            int hours = Integer.parseInt(memes[0]);
            int min = Integer.parseInt(memes[1]);
            if(hours>=12)
            {
                hours-=12;
            }
            double hourDeg = hours*30 + min*.5;
            double minDeg = min*6;
            double degDiff = Math.abs(hourDeg-minDeg);
            if(degDiff>180)
            {
                degDiff = 360-degDiff;
            }
            System.out.printf("The angle between the Hour hand and Minute hand is %.2f degrees.\n", degDiff);
        }
    }
}
