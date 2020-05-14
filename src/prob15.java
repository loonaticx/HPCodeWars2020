import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class prob15 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        String s;
        while((s=br.readLine())!=null){
            String[] temp = s.split(" ");
            if(Integer.parseInt(temp[0])!=0){
                ArrayList<String> commons = new ArrayList<>();
                String first = br.readLine();
                String second = br.readLine();
                String[] firstWor = first.toLowerCase().split(" ");
                String[] secondWor = second.toLowerCase().split(" ");
                for(int i = 0; i<firstWor.length; i++){
                    String tempWord = firstWor[i];
                    if(!commons.contains(tempWord)) {
                        for (int k = 0; k < secondWor.length; k++) {
                            if (tempWord.equals(secondWor[k])) {
                                commons.add(tempWord);
                                break;
                            }
                        }
                    }
                }
                System.out.println(first);
                System.out.println(second);
                System.out.print(commons.size());
                for(String t:commons)
                    System.out.print(" "+t);
                System.out.println();

            }
        }

    }

}
