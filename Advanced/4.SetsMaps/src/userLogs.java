import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class userLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String,LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while(true){
            String inputline = scanner.nextLine();
            if(inputline.equals("end")) break;
            String[] line = inputline.split("=");
            String ip = line[1].split(" ")[0];
            String name = line[line.length-1];
            if(users.containsKey(name)) {
                if (users.get(name).containsKey(ip)) {
                    users.get(name).put(ip, users.get(name).get(ip) + 1);
                } else {
                    users.get(name).put(ip, 1);
                }
            }
            else {
                LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
                temp.put(ip, 1);
                users.put(name,temp);
            }
        }

        String output = new String();
        for(String key : users.keySet()){
            output += key + ": \n";
            for(String ip : users.get(key).keySet()) {
                output += ip + " => " + users.get(key).get(ip) + ", ";
            }
            output = output.substring(0, output.length()-2);
            output += ".\n";
        }
        System.out.println(output);
    }
}
