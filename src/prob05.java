import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob05 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int x = sc.nextInt();
        System.out.print(isPrime(x)? x+ " is PRIME":x+ " is NOT Prime");
    }
    public static boolean isPrime (int x) {
        int sqrt = (int) Math.sqrt(x) + 1;
        for (int i = 2; i < sqrt; i++){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
}
