import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class handsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,HashSet<String>> people = new LinkedHashMap<>();

        while(true){
            String inputline = scanner.nextLine();
            if(inputline.equals("JOKER")) break;
            String[] line = inputline.split(": ");
            String name = line[0];
            String[] cards = line[1].split(", ");
            if(people.containsKey(name)){
                for (String card : cards) {
                    people.get(name).add(card);
                }
            }
            else {
                HashSet<String> temp = new HashSet<>();
                for (String card : cards) {
                    temp.add(card);
                }
                people.put(name,temp);
            }
        }

        for(String key : people.keySet()){
            Integer pts = 0;
            for(String card : people.get(key)){
                String color = card.substring(card.length()-1,card.length());
                String power = card.substring(0,card.length()-1);
                Integer colVal = 0;
                switch (color){
                    case "S": colVal = 4; break;
                    case "H": colVal = 3; break;
                    case "D": colVal = 2; break;
                    case "C": colVal = 1; break;
                }
                switch (power){
                    case "J": power = "11"; break;
                    case "Q": power = "12"; break;
                    case "K": power = "13"; break;
                    case "A": power = "14"; break;
                }
                Integer powVal = Integer.parseInt(power);
                pts += powVal*colVal;
            }
            System.out.println(key + ": " + pts);
        }
    }
}
