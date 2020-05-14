import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class prob17 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int num = Integer.parseInt(br.readLine());

        ArrayList<String> places = new ArrayList<>();
        HashMap<String, ArrayList<String>> routes = new HashMap<>();

        for(int i = 0; i<num; i++){
            String s = br.readLine();
            places.add(s);
            routes.put(s, new ArrayList<>());
        }


        String s;
        while((s = br.readLine())!= null){
            String[] temp = s.split("\\s++");
            String city1 = temp[1];
            String city2 = temp[6];
            String transport = temp[8];
            if(!transport.equals("air")){
                if(!routes.get(city1).contains(city2))
                    routes.get(city1).add(city2);

                if(!routes.get(city2).contains(city1))
                    routes.get(city2).add(city1);
            }
        }

        for(String key: places){
            ArrayList<String> connections = BFS(routes, key);
            if(!connections.isEmpty()) {
                Collections.sort(connections, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return places.indexOf(o1) - places.indexOf(o2);
                    }
                });
                System.out.print("City " + key + " is neighbour to Cities ");
                for(int i = 0; i<connections.size(); i++){
                    if(i==0)
                        System.out.print(connections.get(i));
                    else
                        System.out.print(","+connections.get(i));
                }
            }
            else{
                System.out.print("City "+key+" is remote and has no neighbours");
            }
            System.out.println();
        }
    }

    static ArrayList<String> BFS(HashMap<String, ArrayList<String>> routes, String test){
        Queue<String> q = new LinkedList<>();
        q.offer(test);
        ArrayList<String> visited = new ArrayList<>();
        while(!q.isEmpty()){
            String s = q.poll();
            if(!visited.contains(s)){
                if(!s.equals(test))
                    visited.add(s);
                ArrayList<String> neighbours = routes.get(s);
                if(!neighbours.isEmpty()){
                    for(String temp: neighbours){
                        q.offer(temp);
                    }
                }
            }
        }
        return visited;
    }

}
