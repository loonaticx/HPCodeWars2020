import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class prob13 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        String[] strings = br.readLine().split(" ");

        int yen = Integer.parseInt(strings[0]);
        int item = Integer.parseInt(strings[1]);

        Items[] items = new Items[item];
        for(int y = 0; y<item; y++){
            String[] temp = br.readLine().split(" ");
            items[y] = new Items(temp[0], Integer.parseInt(temp[1]));
        }

        ArrayList<Items> its = new ArrayList<>();
        for(Items i:items)
            its.add(i);

        Items[] items2 = items.clone();
        Arrays.sort(items2, new Comparator<Items>() {
            @Override
            public int compare(Items o1, Items o2) {
                return o1.cost-o2.cost;
            }
        });

        boolean[] buyIt = new boolean[item];
        boolean cont = true;
        Arrays.fill(buyIt, false);

        for(int i = 0; i<items2.length && cont; i++){
            if(items2[i].cost<=yen){
                yen-=items2[i].cost;
                buyIt[its.indexOf(items2[i])] = true;
            }
            else{
                buyIt[its.indexOf(items2[i])] = false;
                cont = false;
            }
        }

        for(int i = 0; i<buyIt.length; i++){
            if(buyIt[i])
                System.out.println("I can afford "+items[i].name);
            else
                System.out.println("I can't afford "+items[i].name);
        }
        boolean canAfford = false;
        for(int i = 0; i<buyIt.length && !canAfford; i++)
            if(buyIt[i])
                canAfford = true;

        if(!canAfford)
            System.out.println("I need more Yen!");

        System.out.println(yen);
    }

    static class Items{
        String name;
        int cost;

        public Items(String name, int cost){
            this.name = name;
            this.cost = cost;
        }
    }

}
