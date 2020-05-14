import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class prob19 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        String puzzle = br.readLine().replaceAll("\\s++", "");
        String question = br.readLine();

        char[] temp = puzzle.toCharArray();
        ArrayList<String> nums = new ArrayList<>();
        for(char c:temp){
            int numOrig = (int) c;
            String hexOfOrig = Integer.toHexString(numOrig);
            nums.add(hexOfOrig);
        }

        StringBuilder sb = new StringBuilder();

        String total = "";

        for(String s: nums)
            total+=s;

        int tempi = 0;
        for(int i = total.length()-1; i>=0; i--){
            if(tempi%4==0){
                sb.append(total.charAt(i));
            }
            tempi++;
        }

        String convert = sb.reverse().toString();

        String ans = "";

        for(int i = 1; i<convert.length(); i+=2){
            String temper = String.valueOf(convert.charAt(i-1))+String.valueOf(convert.charAt(i));
            int conv = Integer.parseInt(temper, 16);
            ans+=(char)conv;
        }

        for(String s: nums)
            System.out.print(s+" ");
        System.out.println();
        System.out.println(convert);

        System.out.print(ans);

    }

}
