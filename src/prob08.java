import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class prob08 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        ArrayList<String> actual = new ArrayList<>();
        while(sc.hasNextLine())
        {
            String meme = sc.nextLine();
            String[] wasteOFSPACE = meme.split(" ");
            for(String i: wasteOFSPACE)
            {
                actual.add(i);
            }
        }
        while(!actual.isEmpty()) {
            String memus = "";
            while (!actual.isEmpty()&&memus.length() + actual.get(0).length()< 80) {
                if(memus.length() == 0)
                    memus+=actual.remove(0);
                else
                    memus+= " " + actual.remove(0);
            }
            System.out.println(memus);
        }
    }
}
