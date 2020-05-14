import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class prob10 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        String[] temper = br.readLine().split(" ");
        String[] temper2 = temper.clone();

        Queue<String> nouns = new LinkedList<>();
        br.readLine();
        String temp;
        while(!(temp=br.readLine()).equals("ADVERBS")){
            nouns.offer(temp);
        }
        Queue<String> adverbs = new LinkedList<>();
        while (!(temp=br.readLine()).equals("VERBS")){
            adverbs.offer(temp);
        }
        Queue<String> verbs = new LinkedList<>();
        while (!(temp=br.readLine()).equals("ADJECTIVES")){
            verbs.offer(temp);
        }
        Queue<String> adjectives = new LinkedList<>();
        while(!(temp=br.readLine()).equals("END")){
            adjectives.offer(temp);
        }


        for(int i = 0; i<temper.length; i++){
            if(temper[i].equals("[AJ]"))
                temper[i] = adjectives.poll();
            else if(temper[i].equals("[N]"))
                temper[i] = nouns.poll();
            else if(temper[i].equals("[AV]"))
                temper[i] = adverbs.poll();
            else if(temper[i].equals("[V]"))
                temper[i] = verbs.poll();
        }

        System.out.println(combine(temper));

        for(int i = 0; i<temper2.length; i++){
            if(temper2[i].equals("[AJ]"))
                temper2[i] = adjectives.poll();
            else if(temper2[i].equals("[N]"))
                temper2[i] = nouns.poll();
            else if(temper2[i].equals("[AV]"))
                temper2[i] = adverbs.poll();
            else if(temper2[i].equals("[V]"))
                temper2[i] = verbs.poll();
        }

        System.out.println(combine(temper2));

    }

    static String combine(String[] temp){
        String ans = temp[0];
        for(int i = 1; i<temp.length; i++){
            ans+=" "+temp[i];
        }
        return ans;
    }

}
