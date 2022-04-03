import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class dragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String,TreeMap<String, Double[]>> dragonsByType = new LinkedHashMap<>();
        HashMap<String,Double[]> typeAverageStats = new HashMap<>();

        while(n>0){
            n--;
            String inputline = scanner.nextLine();
            String[] line = inputline.split(" ");
            String type = line[0];
            String name = line[1];

            Double[] stats = new Double[3];
            for (int i = 2; i < line.length; i++) {
                if(line[i].equals("null")){
                    switch (i){
                        case 2: line[i] = "45"; break;
                        case 3: line[i] = "250"; break;
                        case 4: line[i] = "10"; break;
                    }
                }
                stats[i-2] = Double.parseDouble(line[i]);
            }

            if(dragonsByType.containsKey(type)) {
                dragonsByType.get(type).put(name, stats);
            }
            else {
                TreeMap<String, Double[]> temp = new TreeMap<>();
                temp.put(name, stats);
                dragonsByType.put(type,temp);
            }
        }

        for(String type : dragonsByType.keySet()){
            Double[] temp = {0.00,0.00,0.00};
            typeAverageStats.put(type, temp);
            for(String dragon : dragonsByType.get(type).keySet()) {
                typeAverageStats.get(type)[0] +=  dragonsByType.get(type).get(dragon)[0];
                typeAverageStats.get(type)[1] +=  dragonsByType.get(type).get(dragon)[1];
                typeAverageStats.get(type)[2] +=  dragonsByType.get(type).get(dragon)[2];
            }
            typeAverageStats.get(type)[0] /=  dragonsByType.get(type).size();
            typeAverageStats.get(type)[1] /=  dragonsByType.get(type).size();
            typeAverageStats.get(type)[2] /=  dragonsByType.get(type).size();

        }

        String output = new String();
        for(String type : dragonsByType.keySet()){
            output += String.format("%s::(%.2f/%.2f/%.2f)%n", type,typeAverageStats.get(type)[0],typeAverageStats.get(type)[1],typeAverageStats.get(type)[2]);
            for(String dragon : dragonsByType.get(type).keySet()) {
                output += String.format("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", dragon,dragonsByType.get(type).get(dragon)[0],dragonsByType.get(type).get(dragon)[1],dragonsByType.get(type).get(dragon)[2]);
            }
        }
        System.out.println(output);
    }
}
