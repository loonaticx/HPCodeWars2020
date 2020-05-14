import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob07 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        while(sc.hasNextLine())
        {
            String yeet = sc.nextLine();
            String[] yeetus = yeet.split(" ");
            if(yeetus[0].equals(yeetus[1]))
            {
                System.out.println(yeetus[0]);
            }
            else if(yeetus[0].equals("WHITE"))
            {
                System.out.println("LIGHT " + yeetus[1]);
            }
            else if(yeetus[1].equals("WHITE"))
            {
                System.out.println("LIGHT " + yeetus[0]);
            }
            else if(yeetus[0].equals("BLACK"))
            {
                System.out.println("DARK " + yeetus[1]);
            }
            else if(yeetus[1].equals("BLACK"))
            {
                System.out.println("DARK " + yeetus[0]);
            }
            else if(yeetus[0].equals("RED"))
            {
                if(yeetus[1].equals("BLUE"))
                {
                    System.out.println("PURPLE");
                }
                else
                {
                    System.out.println("ORANGE");
                }
            }
            else if(yeetus[0].equals("BLUE"))
            {
                if(yeetus[1].equals("RED"))
                {
                    System.out.println("PURPLE");
                }
                else
                {
                    System.out.println("GREEN");
                }
            }
            else if(yeetus[0].equals("YELLOW"))
            {
                if(yeetus[1].equals("RED"))
                {
                    System.out.println("ORANGE");
                }
                else
                {
                    System.out.println("GREEN");
                }
            }
        }
    }
}
