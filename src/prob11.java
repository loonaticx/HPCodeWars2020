import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prob11 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        String s;
        while((s=br.readLine())!=null){
            int orig = Integer.parseInt(s);
            String binary = Integer.toString(Integer.parseInt(s, 10), 2);
            if(binary.length()%2==0)
                System.out.println(orig+" no");
            else{
                int numZeros = 0;
                int curr = 0;
                while(curr<binary.length() && numZeros<=1){
                    if(binary.charAt(curr)=='0')
                        numZeros++;
                    curr++;
                }
                if(numZeros>1 || numZeros==0)
                    System.out.println(orig+" no");
                else if(numZeros==1 && binary.charAt(binary.length()/2)=='0')
                    System.out.println(orig+" yes");
                else
                    System.out.println(orig+" no");
            }
        }


    }

}
