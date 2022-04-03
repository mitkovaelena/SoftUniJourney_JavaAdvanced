import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class logsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        TreeMap<String,TreeSet<String>> users = new TreeMap<>();
        HashMap<String,Integer> userDuration = new HashMap<>();

        while(n>0){
            n--;
            String inputline = scanner.nextLine();
            String[] line = inputline.split(" ");
            String ip = line[0];
            String name = line[1];
            Integer duration = Integer.parseInt(line[2]);
            if(users.containsKey(name)) {
                users.get(name).add(ip);
                userDuration.put(name, userDuration.get(name)+duration);
            }
            else {
                TreeSet<String> temp = new TreeSet<>();
                temp.add(ip);
                users.put(name,temp);
                userDuration.put(name, duration);
            }
        }

        String output = new String();
        for(String key : users.keySet()){
            output += key + ": "+ userDuration.get(key) + " [" + users.get(key).toString().replaceAll("\\[|\\]","").replaceAll(",",",") + "]\n";
        }
        System.out.println(output);
    }
}
