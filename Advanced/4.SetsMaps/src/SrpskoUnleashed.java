import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SrpskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,LinkedHashMap<String, Integer>> venuesSinger = new LinkedHashMap<>();

        while(true){
            String inputline = scanner.nextLine();
            if(inputline.equals("End")) break;
            try {
                String[] line = inputline.split(" @");
                String singer = line[0];
                line = line[1].split(" ");
                Integer tickets = Integer.valueOf(line[line.length - 1]) * Integer.valueOf(line[line.length - 2]);
                String venue = "";

            for (int i = 0; i < line.length-2; i++) {
                venue += line[i] + " ";
            }

            if(venuesSinger.containsKey(venue)) {
                if (venuesSinger.get(venue).containsKey(singer)) {
                    venuesSinger.get(venue).put(singer, venuesSinger.get(venue).get(singer) + tickets);
                } else {
                    venuesSinger.get(venue).put(singer, tickets);
                }
            }
            else {
                LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
                temp.put(singer, tickets);
                venuesSinger.put(venue,temp);
            }

            }catch (Exception e){
                continue;
            }
        }




        String output = new String();
        for(String venue : venuesSinger.keySet()){

            Map<String, Integer> sortedSingersPrices = new LinkedHashMap<String, Integer>();
            venuesSinger.get(venue).entrySet().stream()
                    .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                    .forEachOrdered(x -> sortedSingersPrices.put(x.getKey(), x.getValue()));

            output += venue + "\n";
            for(String singer : sortedSingersPrices.keySet()) {
                output += "#  " + singer + " -> " + sortedSingersPrices.get(singer) + "\n";
            }
        }
        System.out.println(output);
    }
}
