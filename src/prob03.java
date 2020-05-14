import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob03 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.print(euclidGCF(x,y));
    }
    private static int euclidGCF(int n1, int n2)
    {
        if(n2 == 0)
            { return n1; }
        return euclidGCF(n2, n1%n2); }
}
