import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prob09 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        String s;
        int totalMins = 50;

        while((s=br.readLine())!=null){
            String[] temp = s.split("\\s++");
            if(Integer.parseInt(temp[0])!=0 || Integer.parseInt(temp[1])!=0){
                int mins = Integer.parseInt(temp[0]);
                int seconds = Integer.parseInt(temp[1]);
                int totalSeconds = mins*60+seconds;
                int totalTime = totalMins*60;

                int leftover = totalTime-totalSeconds;

                int leftMins = leftover/60;
                leftover%=60;
                int leftSecs = leftover;

                System.out.print("Time remaining "+leftMins+" minutes and "+leftSecs+" seconds");

                if(leftMins<25 && (leftMins>=0 || leftSecs>=0))
                    System.out.print(" (we'll need both sides)");
                else if(leftMins<0 || leftSecs<0)
                    System.out.print(" (we're gonna need a bigger record)");

                System.out.println();

            }
        }

    }

}
