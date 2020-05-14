import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class prob22 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        HashMap<String, String[]> strings = new HashMap<>();
        strings.put("A", new String[]{"A","","B","C","","D","","E","F","","G","","A"});
        strings.put("E", new String[]{"E","F","","G","","A","","B","C","","D","","E"});

        String s;
        while((s = br.readLine())!=null){
            String[] temp = s.split("\\s++");
            if(temp.length>1) {
                int fret = Integer.parseInt(temp[0]);
                String string = temp[1];

                String[] notes = strings.get(string);

                int temps = fret+1<=12 ? fret+1 : 0;
                while (notes[temps].equals("")) {
                    temps++;
                }
                System.out.println(notes[temps]);
            }
            else{
                String note = temp[0];

                String[] notesE = strings.get("E");
                int fretE = Arrays.asList(notesE).indexOf(note);

                String[] notesA = strings.get("A");
                int fretA = Arrays.asList(notesA).indexOf(note);

                System.out.println(fretE+" E "+fretA+" A");
            }
        }

    }

}
