import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob23 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int x = sc.nextInt();
        sc.nextLine();
        for(int i =0;i<x;i++)
        {
            String g = sc.nextLine();
            g=g.replaceAll("\\s+","");
            g=g.replaceAll("[^a-zA-Z ]", "");
            g=g.toUpperCase();
            StringBuilder z = new StringBuilder(g);
            StringBuilder f = z.reverse();
            String m = f.toString();
            m=m.replaceAll("[A]", "@");
            m=m.replaceAll("[B]", "%");
            m=m.replaceAll("[D]", "!");
            m=m.replaceAll("[H]", "/");
            m=m.replaceAll("[M]", "&");
            m=m.replaceAll("[N]", "#");
            m=m.replaceAll("[E]", "A");
            m=m.replaceAll("[Q]", "B");
            m=m.replaceAll("[P]", "D");
            m=m.replaceAll("[Y]", "H");
            m=m.replaceAll("[W]", "M");
            m=m.replaceAll("[U]", "N");
            m=m.replaceAll("[@]", "E");
            m=m.replaceAll("[%]", "Q");
            m=m.replaceAll("[!]", "P");
            m=m.replaceAll("[/]", "Y");
            m=m.replaceAll("[&]", "W");
            m=m.replaceAll("[#]", "U");
            System.out.println(m.equals(g)? g+" (is)":g + " (not)");
        }
    }
}
