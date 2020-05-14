import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class prob21 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        String s;

        while((s = br.readLine())!=null){
            String name = s.split("\\s++")[1];
            double rate = Double.parseDouble(br.readLine().split("\\s++")[1]);
            String in1Temp = br.readLine().split("\\s++")[1];
            String out1Temp = br.readLine().split("\\s++")[1];
            String in2Temp = br.readLine().split("\\s++")[1];
            String out2Temp = br.readLine().split("\\s++")[1];

            int totalHours = 0;
            int totalMins = 0;

            int hours;
            int mins;

            if(Integer.parseInt(out1Temp.substring(2))>=Integer.parseInt(in1Temp.substring(2))){
                hours = Integer.parseInt(out1Temp.substring(0,2))-Integer.parseInt(in1Temp.substring(0,2));
            }else{
                hours = Integer.parseInt(out1Temp.substring(0,2))-Integer.parseInt(in1Temp.substring(0,2))-1;
            }

            mins = Integer.parseInt(out1Temp.substring(2))-Integer.parseInt(in1Temp.substring(2))>=0 ? Integer.parseInt(out1Temp.substring(2))-Integer.parseInt(in1Temp.substring(2)):60-Math.abs(Integer.parseInt(out1Temp.substring(2))-Integer.parseInt(in1Temp.substring(2)));
            totalHours+=hours;
            totalMins+=mins;

            if(Integer.parseInt(out2Temp.substring(2))>=Integer.parseInt(in2Temp.substring(2))){
                hours = Integer.parseInt(out2Temp.substring(0,2))-Integer.parseInt(in2Temp.substring(0,2));
            }else{
                hours = Integer.parseInt(out2Temp.substring(0,2))-Integer.parseInt(in2Temp.substring(0,2))-1;
            }

            mins = Integer.parseInt(out2Temp.substring(2))-Integer.parseInt(in2Temp.substring(2))>=0 ? Integer.parseInt(out2Temp.substring(2))-Integer.parseInt(in2Temp.substring(2)):60-Math.abs(Integer.parseInt(out2Temp.substring(2))-Integer.parseInt(in2Temp.substring(2)));
            totalHours+=hours;
            totalMins+=mins;

            if(totalMins>60){
                totalHours+=totalMins/60;
                totalMins%=60;
            }

            double totalMoney = (totalHours+(totalMins/60.0))*rate;

            System.out.println(name+" earned $"+String.format("%.2f", totalMoney));

        }

    }

}
