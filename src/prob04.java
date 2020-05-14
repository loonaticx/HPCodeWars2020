import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prob04 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int num = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        System.out.print(LCM(num, num2));
    }

    static int LCM(int num1, int num2){
        int temp = Math.max(num1, num2);
        while(!(temp%num1==0 && temp%num2==0)){
            temp+=Math.max(num1, num2);
        }
        return temp;
    }

}
