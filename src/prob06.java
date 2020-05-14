import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class prob06 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        HashMap<Integer, String> roman = new HashMap<>();
        roman.put(1, "B");
        roman.put(4, "BW");
        roman.put(5, "W");
        roman.put(9, "BZ");
        roman.put(10, "Z");
        roman.put(40, "ZP");
        roman.put(50, "P");
        roman.put(90, "ZB");
        roman.put(100, "B");
        roman.put(400, "BG");
        roman.put(500, "G");
        roman.put(900, "BR");
        roman.put(1000, "R");

        int[] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000};

        String s;
        while((s=br.readLine())!=null){
            String ans = "";
            int temp = Integer.parseInt(s);
            while(temp>0){
                for(int i = nums.length-1; i>=0; i--){
                    int times = 0;
                    if(nums[i]<=temp){
                        times = temp/nums[i];
                        temp%=nums[i];
                    }
                    for(int k = 0; k<times; k++){
                        ans+=roman.get(nums[i]);
                    }
                }
            }
            System.out.println(ans);
        }

    }

}
